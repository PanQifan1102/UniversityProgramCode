# ====================
# 坦克的设计。
# 版本号：1.0.15
# 作者：潘琦藩
# ====================
import random

# 相关头文件的包含
import pygame
from setting import *
from 坦克大战.bullet import Bullet
from 坦克大战.sprite import SpriteObject


# 坦克类的创建
class Tank(SpriteObject):
    def __init__(self, left, top):
        super(SpriteObject, self).__init__()
        """
        :param left: 左边距
        :param top:  上边距
        """
        self.images = {  # 存放不同方向的照片，备选
            'U': pygame.image.load('res/img/tank_up.png'),
            'D': pygame.image.load('res/img/tank_down.png'),
            'L': pygame.image.load('res/img/tank_left.png'),
            'R': pygame.image.load('res/img/tank_right.png'),
        }
        # 坦克的初始方向
        self.direction = 'U'
        # 当前显示的图片
        self.image = self.images[self.direction]
        # 获取图片当前区域
        self.rect = self.image.get_rect()
        # 设置坦克的初始位置
        self.rect.left = left
        self.rect.top = top
        # 设置坦克的速度
        self.speed = MOVE_SPEED
        # 设置移动开关
        self.stop = True
        # 设置用于保存坦克历史起始位置的两个属性
        self.lastLeft = self.rect.left
        self.lastTop = self.rect.top

    # 移动方法
    def move(self):
        self.lastLeft = self.rect.left  # 每次移动操作前，记录上一次的位置
        self.lastTop = self.rect.top
        if self.direction == 'L':  # 朝向左移动
            if self.rect.left > 0:
                self.rect.left -= self.speed
        elif self.direction == 'R':  # 朝向右移动
            if self.rect.left+self.rect.width < SCREEN_SIZE[0]:
                self.rect.left += self.speed
        elif self.direction == 'U':  # 朝向上移动
            if self.rect.top > 0:
                self.rect.top -= self.speed
        elif self.direction == 'D':
            if self.rect.top + self.rect.height < SCREEN_SIZE[1]:
                self.rect.top += self.speed

    # 碰上障碍时，通过该方法保持坦克原地不动
    def halt(self):
        self.rect.left = self.lastLeft
        self.rect.top = self.lastTop

    # 坦克的显示方法
    def display(self,screen):
        # 根据当前方向取得要展示的image对象
        self.image = self.images[self.direction]
        screen.blit(self.image, self.rect)

    # 坦克的设计方法
    def shot(self):
        return Bullet(self)

    # 检测与其他坦克的碰撞
    def checkCollide(self, spriteObjectList):
        for obj in spriteObjectList:
            # 此处判断要排除obj对象可能为None的情况
            if obj and obj is not self and pygame.sprite.collide_rect(obj, self):
                self.halt()  # 坦克停止移动的方法


# 电脑方坦克类
class EnemyTank(Tank):
    def __init__(self, left, top):
        super().__init__(left, top)
        self.images = {  # 存放不同方向的坦克图片
            'U': pygame.image.load('res/img/entank_up.png'),
            'D': pygame.image.load('res/img/entank_down.png'),
            'L': pygame.image.load('res/img/entank_left.png'),
            'R': pygame.image.load('res/img/entank_right.png'),
        }
        # 初始方向
        self.direction = self.randDirection()
        # 设置转向计步变量
        self.step = STEP

    def randDirection(self):
        return ['U', 'D', 'L', 'R'][random.randint(0, 3)]

    def randMove(self):
        if self.step <= 0:
            self.direction = self.randDirection()
            # 变换方向后，重置计步数
            self.step = STEP
        else:
            self.move()
            self.step -= 1  # 每移动一次，计步数减少一次

    # 射击方法
    def shot(self):
        num = random.randint(1, 1000)
        if num < 10:
            return Bullet(self)


