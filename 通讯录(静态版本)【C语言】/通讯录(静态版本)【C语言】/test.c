#define _CRT_SECURE_NO_WARNINGS 1
#include "Contact.h"

//操作符枚举
enum Option
{
	Exit,//0,退出通讯录
	Add,//1，增加通讯录联系人
	Del,//2，删除通讯录联系人
	Search,//3，查找通讯录联系人
	Modify,//4，修改通讯联系人
	Show,//5，展示通讯录
	Sort//6，排序通讯录
};
//通讯录菜单的实现
void menu()
{
	printf("====通讯录菜单====\n");
	printf("1.add     2.del\n");
	printf("3.search  4.modify\n");
	printf("5.show    6.sort\n");
	printf("0.exit\n");
	printf("==================\n");
}
//函数主体的实现
int main()
{
	int input = 0;
	Contact con;//创建出一个通讯录
	//====================================
	//初始化通讯录
	InitContact(&con);
	do
	{
		menu();
		printf("请输入要进行的选项代号：");
		scanf("%d", &input);

		switch (input)
		{
		case Add: 
			AddContact(&con);
			break;
		case Del:
			DelContact(&con);
			break;
		case Search:
			SearchContact(&con);
			break;
		case Modify:
			ModifyContact(&con);
			break;
		case Show:
			ShowContact(&con);
			break;
		case Sort:
			SortContact(&con);
			break;
		case Exit:
			printf("退出通讯录！\n");
			break;
		default:
			printf("选择错误，重新选择！\n");
			break;
		}
	} while (input);
	return 0;
}