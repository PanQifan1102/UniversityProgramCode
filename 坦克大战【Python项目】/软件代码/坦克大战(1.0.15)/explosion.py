# ====================
# 爆炸类的实现。
# 版本号：1.0.15
# 作者：潘琦藩
# ====================
import pygame.image


class Explosion:
    images = [
        pygame.image.load('res/img/explosion-1.png'),
        pygame.image.load('res/img/explosion-2.png'),
        pygame.image.load('res/img/explosion-3.png'),
        pygame.image.load('res/img/explosion-4.png'),
        pygame.image.load('res/img/explosion-5.png'),
    ]

    def __init__(self, tank):
        self.frameIndex = 0  # 爆炸图片的序号，初始化为0。-1表示无效状态
        self.image = Explosion.images[self.frameIndex]
        rect = self.image.get_rect()
        self.rect = tank.rect  # 通过坦克对象的rect属性获取起始显示位置
        # 爆炸图片与坦克图片的大小不一样，因此起始坐标要重新计算。默认二者的中心点是一样的。
        self.rect.left = tank.rect.left - (rect.width - tank.rect.width) / 2
        self.rect.top = tank.rect.top - (rect.height - tank.rect.height) / 2

    def display(self, screen):
        if self.frameIndex < len(self.images):
            screen.blit(self.image, self.rect)
            self.image = self.images[self.frameIndex]
            self.frameIndex += 1
        else:
            self.frameIndex = -1
