#define _CRT_SECURE_NO_WARNINGS 1
#include "Contact.h"
//��ʼ��ͨѶ¼
void InitContact(Contact* pc)
{
	pc->sz = 0;//�����ȳ�ʼ��Ϊ0
	memset(pc->data, 0, sizeof(pc->data));//��data��������
	                                      //Ԫ�س�ʼ��Ϊ0
}

//����ͨѶ¼��ϵ��
void AddContact(Contact* pc)
{
	//�ж�ͨѶ¼����������
	if (pc->sz == MAX)
	{
		printf("�������ͣ��޷���ӣ�\n");
		return;
	}
	//������ϵ����Ϣ
	printf("��������ϵ��������");
	scanf("%s", pc->data[pc->sz].name);
	printf("��������ϵ�����䣺");
	scanf("%d", &pc->data[pc->sz].age);
	printf("��������ϵ���Ա�");
	scanf("%s", pc->data[pc->sz].sex);
	printf("��������ϵ�˵绰��");
	scanf("%s", pc->data[pc->sz].tele);
	printf("��������ϵ��סַ��");
	scanf("%s", pc->data[pc->sz].addr);

	pc->sz++;
	printf("��ӳɹ�\n");
}

//��ʾ��ϵ����Ϣ
void ShowContact(const Contact* pc)
{
	int i = 0;
	printf("%-10s %-5s %-5s %-13s %-20s\n",
		"����", "����", "�Ա�", "�绰", "סַ");
	for (i = 0;i < pc->sz;i++)
	{
		printf("%-10s %-5d %-5s %-13s %-20s\n",
			pc->data[i].name, pc->data[i].age, pc->data[i].sex,
			pc->data[i].tele, pc->data[i].addr);
	}
}
//��װ�Ĳ�ѯ���ֵĺ���
//ͨ��static���Σ��Ǹú���ֻ���ڴ�Դ�ļ���ʹ�á�
static int FindByName(const Contact* pc, char name[])
{
	int i = 0;
	int pos = 0;
	for (i = 0;i < pc->sz;i++)
	{
		if (0 == strcmp(pc->data[i].name, name))
		{
			return i;
		}
	}
	return -1;
}
//ɾ����ϵ����Ϣ
void DelContact(Contact* pc)
{
	//�ж�ͨѶ¼�Ƿ�Ϊ��
	if (pc->sz == 0)
	{
		printf("ͨѶ¼Ϊ�գ��޷�ɾ����\n");
		return;
	}
	//�ҵ�Ҫɾ�����˵�λ��
	char search_name[MAX_NAME] = { 0 };
	printf("������Ҫ�����˵����֣�");
	scanf("%s", search_name);
	//int pos = 0;//�洢�ҵ���λ��
	int pos = FindByName(pc, search_name);
	/*int i = 0;//��װ��һ����
	int pos = 0;
	for (i = 0;i < pc->sz;i++)
	{
		if (0 == strcmp(pc->data[i].name, search_name))
		{
			pos = i;
			break;
		}
	}*/
	if (pos == -1)
	{
		printf("Ҫɾ�����˲����ڣ�\n");
	}
	int i = 0;
	//ɾ��posλ���ϵ�����
	for (i = pos;i < pc->sz - 1;i++)
	{
		pc->data[i] = pc->data[i + 1];//ͨ����һ��Ԫ�����θ���
		                              //ԭ��ǰһ��Ԫ�ص�λ����
		                              //�ﵽɾ����Ŀ��
	}
	pc->sz--;
	printf("ɾ���ɹ���\n");
}
//����ָ����ϵ��
void SearchContact(const Contact* pc)
{
	char name[MAX_NAME] = { 0 };
	printf("������Ҫ�����˵����֣�");
	scanf("%s", name);
	//ͨ����������
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("Ҫ���ҵ��˲����ڣ�\n");
		return;
	}
	//��ӡ�ҵ����˵���Ϣ
	printf("%-10s %-5s %-5s %-13s %-20s\n",
		"����", "����", "�Ա�", "�绰", "סַ");
	printf("%-10s %-5d %-5s %-13s %-20s\n",
		pc->data[pos].name, pc->data[pos].age, pc->data[pos].sex,
		pc->data[pos].tele, pc->data[pos].addr);
}
//�޸�ָ����ϵ��
void ModifyContact(Contact* pc)
{
	char name[MAX_NAME] = { 0 };
	printf("������Ҫ�޸��˵����֣�");
	scanf("%s", name);
	int pos =FindByName(pc, name);
	if (pos == -1)
	{
		printf("Ҫ�޸ĵ��˲����ڣ�\n");
		return;
	}
	//�޸���Ϣ��������������Ϣ����
	printf("��������ϵ��������");
	scanf("%s", pc->data[pc->sz].name);
	printf("��������ϵ�����䣺");
	scanf("%d", &pc->data[pc->sz].age);
	printf("��������ϵ���Ա�");
	scanf("%s", pc->data[pc->sz].sex);
	printf("��������ϵ�˵绰��");
	scanf("%s", pc->data[pc->sz].tele);
	printf("��������ϵ��סַ��");
	scanf("%s", pc->data[pc->sz].addr);

	printf("�޸ĳɹ���\n");
}
//qsort�����ȽϺ���(ͨ����������)
int CmpByName(const void* e1, const void* e2)
{
	return strcmp(((PeoInfo*)e1)->name, ((PeoInfo*)e2)->name);
}
//����ͨѶ¼��Ϣ
void SortContact(Contact* pc)
{
	qsort(pc->data,pc->sz,sizeof(PeoInfo), CmpByName);
}