# ====================
# 坦克的设计。
# 版本号：1.0.2
# 作者：潘琦藩
# ====================
import pygame


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

    # 坦克的显示方法
    def display(self,screen):
        # 根据当前方向取得要展示的image对象
        self.image = self.images[self.direction]
        screen.blit(self.image, self.rect)