#define _CRT_SECURE_NO_WARNINGS 1
#include "Contact.h"

//������ö��
enum Option
{
	Exit,//0,�˳�ͨѶ¼
	Add,//1������ͨѶ¼��ϵ��
	Del,//2��ɾ��ͨѶ¼��ϵ��
	Search,//3������ͨѶ¼��ϵ��
	Modify,//4���޸�ͨѶ��ϵ��
	Show,//5��չʾͨѶ¼
	Sort//6������ͨѶ¼
};
//ͨѶ¼�˵���ʵ��
void menu()
{
	printf("====ͨѶ¼�˵�====\n");
	printf("1.add     2.del\n");
	printf("3.search  4.modify\n");
	printf("5.show    6.sort\n");
	printf("0.exit\n");
	printf("==================\n");
}
//���������ʵ��
int main()
{
	int input = 0;
	Contact con;//������һ��ͨѶ¼
	//====================================
	//��ʼ��ͨѶ¼
	InitContact(&con);
	do
	{
		menu();
		printf("������Ҫ���е�ѡ����ţ�");
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
			printf("�˳�ͨѶ¼��\n");
			break;
		default:
			printf("ѡ���������ѡ��\n");
			break;
		}
	} while (input);
	return 0;
}