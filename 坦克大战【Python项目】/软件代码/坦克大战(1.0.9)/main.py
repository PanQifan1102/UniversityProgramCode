# ====================
# 程序基本框架。
# 版本号：1.0.9
# 作者：潘琦藩
# ====================

# 相关头文件的包含
import sys
import pygame
from setting import *
from tank import *


# 游戏主类的创建
class TankGame:
    def __init__(self):
        self.window = None
        self.playerTank = None  # 增加玩家坦克变量
        self.computerTankList = []
        self.bulletList = []
        self.computerBulletList = []

    # 初始化玩家坦克的方法
    def initPlayerTank(self):
        self.playerTank = Tank(400, 540)

    # 玩家坦克的显示处理
    def displayPlayerTank(self):
        # 有效状态检测
        if self.playerTank and self.playerTank.alive:
            self.playerTank.display(self.window)
            # 检查坦克对象是否为移动状态
            if self.playerTank and not self.playerTank.stop:
                self.playerTank.move()  # 通过调用move方法，实现移动
            # 检查玩家坦克与电脑方坦克的碰撞
            self.playerTank.checkCollide(self.computerTankList)
        elif self.playerTank:
            self.playerTank = None

    # 事件处理代码
    def eventProcess(self):
        # 获取事件，开始事件处理
        # eventList = pygame.event.get()
        for event in pygame.event.get():
            # 判断是否按下关闭键
            if event.type == pygame.QUIT:
                self.exit()
            # 按键事件的处理
            if event.type == pygame.KEYDOWN:
                if self.playerTank:
                    # 按下方向键，改变移动状态
                    if event.key in (pygame.K_LEFT,
                                     pygame.K_RIGHT,
                                     pygame.K_UP,
                                     pygame.K_DOWN):
                        self.playerTank.stop = False  # 移动状态
                    if event.key == pygame.K_LEFT:
                        self.playerTank.direction = 'L'

                    elif event.key == pygame.K_RIGHT:
                        self.playerTank.direction = 'R'

                    elif event.key == pygame.K_UP:
                        self.playerTank.direction = 'U'

                    elif event.key == pygame.K_DOWN:
                        self.playerTank.direction = 'D'

                    elif event.key == pygame.K_SPACE:
                        # 控制玩家在画面上的最多子弹数，PLAYER_SHOT_LIMIT小于0表示不限制
                        if PLAYER_SHOT_LIMIT < 0 or \
                                len(self.bulletList) < PLAYER_SHOT_LIMIT:
                            # 创建子弹
                            self.bulletList.append(self.playerTank.shot())
            if event.type == pygame.KEYUP:
                # 抬起方向键，改为停止状态
                if self.playerTank and event.key in (pygame.K_LEFT,
                                                     pygame.K_RIGHT,
                                                     pygame.K_UP,
                                                     pygame.K_DOWN):
                    self.playerTank.stop = True  # 停止状态

    # 初始化电脑方坦克
    def initComputerTanks(self, n):
        top = 10
        # 循环生成电脑方坦克
        for i in range(n):
            left = random.randint(0, 600)
            e = EnemyTank(left, top)
            self.computerTankList.append(e)

    # 显示电脑方坦克
    def displayComputerTanks(self):
        # 通过循环方式，逐个显示电脑方坦克
        for ct in self.computerTankList[:]:
            # 判断坦克状态是否有效
            if ct.alive:
                ct.display(self.window)
                ct.randMove()
                # 调用电脑坦克对象的射击方法，如果射击了，就返回一个新的子弹对象
                bb = ct.shot()
                # 如果变量不空，则表示有子弹产生
                if bb:
                    self.computerBulletList.append(bb)  # 将新生成的子弹对象添加到列表中
                # 添加碰撞检测语句
                ct.checkCollide([self.playerTank])  # 检测与玩家坦克的碰撞
                ct.checkCollide(self.computerTankList)  # 检测与其他坦克的碰撞
            else:  # 子弹无效则移除
                self.computerTankList.remove(ct)

    # 显示玩家子弹
    def displayBullets(self):
        # 通过循环来显示子弹
        for bullet in self.bulletList[:]:
            if bullet.alive:
                bullet.display(self.window)
                bullet.move()
                bullet.checkTankCollide(self.computerTankList)  # 增加子弹的碰撞检测
            else:  # 子弹飞出窗口或射中目标则删除，子弹无效则移除
                self.bulletList.remove(bullet)

    # 显示电脑方坦克的子弹
    def displayComputerBulltes(self):
        for bullet in self.computerBulletList[:]:
            if bullet.alive:
                bullet.display(self.window)
                bullet.move()
                bullet.checkTankCollide([self.playerTank])  # 增加子弹的碰撞检测
            else:  # 子弹飞出窗口或射中目标则删除，子弹无效则移除
                self.computerBulletList.remove(bullet)

    # 游戏主程序
    def run(self):
        # 初始化pygame
        pygame.init()
        # 设置窗口的大小
        self.window = pygame.display.set_mode(SCREEN_SIZE)
        # 设置游戏窗口的标题
        pygame.display.set_caption("坦克大战(1.0.9)")
        self.initPlayerTank()  # 玩家坦克的初始化
        self.initComputerTanks(5)  # 初始化电脑方坦克
        clock = pygame.time.Clock()  # 创建Clock对象
        while True:
            # 给窗口设置填充的颜色
            self.window.fill(BG_COLOR)

            self.displayPlayerTank()  # 显示玩家的坦克
            self.displayComputerTanks()  # 显示电脑方坦克
            self.displayBullets()  # 显示并移动玩家的子弹
            self.displayComputerBulltes()  # 显示并移动电脑方坦克的子弹
            self.eventProcess()

            pygame.display.update()

            # eventList = pygame.event.get()
            #
            # for event in eventList:
            #     # 判断是否点击了退出的按钮
            #     if event.type == pygame.QUIT:
            #         self.exit()
            # pygame.display.update()

            clock.tick(FPS)

    # 结束游戏
    def exit(self):
        # 卸载pygame装载的所有模块
        pygame.quit()
        # 终止程序
        sys.exit()


if __name__ == '__main__':
    TankGame().run()
