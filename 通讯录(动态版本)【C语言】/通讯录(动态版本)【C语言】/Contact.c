#define _CRT_SECURE_NO_WARNINGS 1
#include "Contact.h"
//�����ļ�����Ϣ��ͨѶ¼
void CheckCapacity(Contact* pc);
void LoadContact(Contact * pc)
{
	//���ļ�
	FILE* pf =fopen("contact.dat", "rb");
	if (pf == NULL)
	{
		perror("LoadContact::fopen");
		return;
	}
	//���ļ�
	PeoInfo tmp = { 0 };
	while (fread(&tmp, sizeof(PeoInfo), 1, pf))
	{
		CheckCapacity(pc);
		pc->data[pc->sz] = tmp;
		pc->sz++;
	}
	//�ر��ļ�
	fclose(pf);
	pf = NULL;
}
//��ʼ��ͨѶ¼
void InitContact(Contact* pc)
{
	pc->data = (PeoInfo*)malloc(DEFAULT_SZ * sizeof(PeoInfo));
	if (pc->data == NULL)
	{
		printf("ͨѶ¼��ʼ��ʧ�ܣ�ԭ���ǣ�%s\n",strerror(errno));
		return;
	}
	pc->sz = 0;
	pc->capacity = DEFAULT_SZ;
	//�����ļ�����Ϣ��ͨѶ¼��
	LoadContact(pc);
}
//�жϿռ��Ƿ�����
void CheckCapacity(Contact* pc)
{
	if (pc->sz == pc->capacity)
	{
		PeoInfo* ptr = (PeoInfo*)realloc(pc->data, (pc->capacity + INC_SZ) * sizeof(PeoInfo));
		if (ptr == NULL)
		{
			printf("CheckCapacity:%s\n", strerror(errno));
			return;
	    }
		else
		{
			pc->data = ptr;
			pc->capacity += INC_SZ;
			printf("���ݳɹ�����ǰ�����ǣ�%d\n", pc->capacity);
		}
	}
}
//����ͨѶ¼��ϵ��
void AddContact(Contact* pc)
{
	//�ж�Ҫ��Ҫ����
	CheckCapacity(pc);
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
	int pos = FindByName(pc, name);
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
void SortContact(const Contact* pc)
{
	qsort(pc->data, pc->sz, sizeof(PeoInfo), CmpByName);
}
//����ͨѶ¼
void DestroyContact(Contact* pc)
{
	free(pc->data);
	pc->data = NULL;
	pc->capacity = 0;
	pc->sz = 0;
}
//����ͨѶ¼
void SaveContact(Contact* pc)
{
	FILE* pf = fopen("contact.dat", "wb");
	if (pf == NULL)
	{
		perror("SaveContact::fopen");
		return;
	}
	//д����
	int i = 0;
	for (i = 0;i < pc->sz;i++)
	{
		fwrite(pc->data+i,sizeof(struct PeoInfo),1,pf);
	}
	//�ر��ļ�
	fclose(pf);
	pf = NULL;
	printf("����ɹ���\n");
}