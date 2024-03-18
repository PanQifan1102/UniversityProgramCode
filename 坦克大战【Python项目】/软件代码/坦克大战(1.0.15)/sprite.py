# ====================
# 实现碰撞检测的精灵类。
# 版本号：1.0.15
# 作者：潘琦藩
# ====================
import pygame


# 为了实现碰撞检测，定义一个继承Sprite类的共同类
# 这样tank，bullet等就可以借助精灵类实现碰撞
class SpriteObject(pygame.sprite.Sprite):
    def __init__(self):
        # 调用父类（Sprite）的构造方法
        super().__init__(self)

        # 表示有效元素
        self.alive = True