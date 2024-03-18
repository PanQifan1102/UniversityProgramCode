# ====================
# 程序基本框架。
# 版本号：1.0.1
# 作者：潘琦藩
# ====================

# 相关头文件的包含
from head import *

class TankGame:
    def __init__(self):
        self.window = None

    # 游戏主程序
    def run(self):
        # 初始化pygame
        pygame.init()
        # 设置窗口的大小
        self.window = pygame.display.set_mode(SCREEN_SIZE)
        # 设置游戏窗口的标题
        pygame.display.set_caption("坦克大战(1.0.1)")

        while True:
            # 给窗口设置填充的颜色
            self.window.fill(BG_COLOR)
            # 获取事件，开始事件处理
            eventList = pygame.event.get()

            for event in eventList:
                # 判断是否点击了退出的按钮
                if event.type == pygame.QUIT:
                    self.exit()
            pygame.display.update()

    # 结束游戏
    def exit(self):
        # 卸载pygame装载的所有模块
        pygame.quit()
        # 终止程序
        sys.exit()


if __name__ == '__main__':
    TankGame().run()
