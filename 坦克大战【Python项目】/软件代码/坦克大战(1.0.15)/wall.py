# ====================
# 障碍类的设计。
# 版本号：1.0.15
# 作者：潘琦藩
# ====================
import pygame.image

from 坦克大战.setting import WALL_LIFE
from 坦克大战.sprite import SpriteObject


class Wall(SpriteObject):
    def __init__(self, left, top):
        super(SpriteObject, self).__init__()
        self.image = pygame.image.load('res/img/wall.png')
        self.rect = self.image.get_rect()
        self.rect.left = left
        self.rect.top = top
        # 设置是否有效的标志
        self.alive = True
        # 设置墙的生命值
        self.life = WALL_LIFE

    # 显示方法
    def display(self, screen):
        screen.blit(self.image, self.rect)

