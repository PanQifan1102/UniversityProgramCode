# ====================
# 坦克的设计。
# 版本号：1.0.4
# 作者：潘琦藩
# ====================
# 相关头文件的包含
import pygame
from setting import *


# 坦克类的创建
class Tank:
    def __init__(self, left, top):
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

    # 移动方法
    def move(self):
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

    # 坦克的显示方法
    def display(self,screen):
        # 根据当前方向取得要展示的image对象
        self.image = self.images[self.direction]
        screen.blit(self.image, self.rect)
