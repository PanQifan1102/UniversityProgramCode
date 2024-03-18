# ====================
# 面板类的设计。
# 版本号：1.0.15
# 作者：潘琦藩
# ====================
import pygame

from 坦克大战 import setting


class Panel:
    # 右边面板的宽度和高度
    PANELWIDTH, PANELHEIGHT = setting.PANELWIDTH, setting.SCREEN_SIZE[1]
    # 右边条面的左上角点
    PANELLEFT, PANELTOP = setting.SCREEN_SIZE[0], 0

    # 设置显示位置
    def __init__(self, playerCount=setting.PLAYER_LIFE, totalTanks=setting.TOTAL_COMPUTER_TANKS):
        # 准备控制面板的Surface
        self.panel = pygame.Surface((Panel.PANELWIDTH, Panel.PANELHEIGHT),
                                    flags=pygame.HWSURFACE)
        # 填充方块显示色
        self.panel.fill((190, 190, 190))
        self.panelpoint = (Panel.PANELLEFT, Panel.PANELTOP)
        # 最多显示十二个电脑方坦克
        self.tank_iconimg = pygame.image.load('res/img/tank_icon.png')
        self.tankicon_point = (self.PANELLEFT + 10, 30)
        # 玩家的图标
        self.player_icon = pygame.image.load('res/img/player_icon.png')
        self.player_point = (Panel.PANELLEFT + 10, Panel.PANELHEIGHT - 50)
        self.icon_points = []
        self.font = pygame.font.Font('c:/windows/Fonts/simhei.ttf', 20)
        self.player_count = playerCount
        self.player_count_text = self.font.render(
            str(self.player_count), True, (255, 0, 0), (190, 190, 190)
        )
        # 获得显示对象的方块(rect)区域的坐标
        self.text_position = (Panel.PANELLEFT+35, Panel.PANELHEIGHT-45)
        self.reset(totalTanks)

    def display(self, screen):
        screen.blit(self.panel, self.panelpoint)
        for i in range(len(self.icon_points) // 2):
            screen.blit(self.tank_iconimg, self.icon_points[2*i])
            screen.blit(self.tank_iconimg, self.icon_points[2*i + 1])
        if len(self.icon_points) > 0 and len(self.icon_points) % 2:
            screen.blit(self.tank_iconimg, self.icon_points[len(self.icon_points) - 1])
        screen.blit(self.player_icon, self.player_point)
        screen.blit(self.player_count_text, self.text_position)

    # 初始化坦克图标的定位坐标列表
    def reset(self, total):
        row = total // 2 + total % 2
        for i in range(row):
            # self.tankicon_point 是坦克图标显示位置的坐标元组
            self.icon_points.append((self.tankicon_point[0], self.tankicon_point[1] + 20 * i))
            self.icon_points.append((self.tankicon_point[0] + 20, self.tankicon_point[1] + 20 * i))
        if total % 2:
            self.icon_points.pop()

    # 减少坦克图标数
    def cutdown(self, n):
        for i in range(n):
            self.icon_points.pop()

    def setPlayer(self, n):
        self.player_count = n
        self.player_count_text = self.font.render(
            str(self.player_count), True, (255, 0, 0), (190, 190, 190)
        )


