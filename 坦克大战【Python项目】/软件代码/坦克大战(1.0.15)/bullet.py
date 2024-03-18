# ====================
# 子弹的设计。
# 版本号：1.0.15
# 作者：潘琦藩
# ====================
import pygame.image

from 坦克大战 import *
from 坦克大战.explosion import Explosion
from 坦克大战.setting import *
from 坦克大战.sprite import SpriteObject


class Bullet(SpriteObject):
    images = {  # 存放不同方向的子弹图片
        'U': pygame.image.load('res/img/bullet-U.png'),
        'D': pygame.image.load('res/img/bullet-D.png'),
        'L': pygame.image.load('res/img/bullet-L.png'),
        'R': pygame.image.load('res/img/bullet-R.png'),
    }

    def __init__(self, tank):
        super(SpriteObject, self).__init__()
        # 子弹的方向与坦克一至
        self.direction = tank.direction
        # 设置子弹的图片
        self.image = Bullet.images.get(self.direction)
        # 获取区域
        self.rect = self.image.get_rect()
        # 子弹的初始位置与坦克的方向有关
        if self.direction == 'U':
            self.rect.left = tank.rect.left + tank.rect.width / 2 - self.rect.width / 2
            self.rect.top = tank.rect.top - self.rect.height
        elif self.direction == 'D':
            self.rect.left = tank.rect.left + tank.rect.width / 2 - self.rect.width / 2
            self.rect.top = tank.rect.top + self.rect.height
        elif self.direction == 'L':
            self.rect.left = tank.rect.left - self.rect.width
            self.rect.top = tank.rect.top + tank.rect.height / 2 - self.rect.height / 2
        elif self.direction == 'R':
            self.rect.left = tank.rect.left + self.rect.width
            self.rect.top = tank.rect.top + tank.rect.height / 2 - self.rect.height / 2

        # 子弹的速度
        self.speed = MOVE_SPEED * 2
        # 表示子弹是否有效，初始化为有效状态
        self.alive = True

    # 子弹的显示方法
    def display(self, screen):
        screen.blit(self.image, self.rect)

    # 子弹的移动方法
    def move(self):
        if self.direction == 'L':
            if self.rect.left >= 0:
                self.rect.left -= self.speed
        elif self.direction == 'R':
            if self.rect.left + self.rect.width < SCREEN_SIZE[0]:
                self.rect.left += self.speed
        elif self.direction == 'U':
            if self.rect.top >= 0:
                self.rect.top -= self.speed
        elif self.direction == 'D':
            if self.rect.top + self.rect.height < SCREEN_SIZE[1]:
                self.rect.top += self.speed
        # 判断返回是否准确
        if self.rect.left < 0 or \
                self.rect.left + self.rect.width >= SCREEN_SIZE[0] or \
                self.rect.top < 0 or \
                self.rect.top + self.rect.height >= SCREEN_SIZE[1]:
            self.alive = False

    # 检查子弹与坦克是否碰撞上
    def checkTankCollide(self, tankList):
        result = []
        for tank in tankList:
            # 判断要排除tank为None的情况
            if tank and pygame.sprite.collide_rect(tank, self):
                tank.alive = False
                self.alive = False
                result.append(Explosion(tank))
        return result

    # 子弹与墙碰撞检测的方法
    def checkWallCollide(self, wallList):
        for wall in wallList:  # 遍历全部墙
            if pygame.sprite.collide_rect(wall, self):
                self.alive = False  # 发生碰撞，就设置子弹为无效状态
                wall.life -= 1  # 墙的生命值减一
                if wall.life <= 0:
                    wall.alive = False  # 墙的生命小于零时，也会被设置为无效状态
