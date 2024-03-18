#define _CRT_SECURE_NO_WARNINGS 1
#include "Contact.h"
//加载文件的信息到通讯录
void CheckCapacity(Contact* pc);
void LoadContact(Contact * pc)
{
	//打开文件
	FILE* pf =fopen("contact.dat", "rb");
	if (pf == NULL)
	{
		perror("LoadContact::fopen");
		return;
	}
	//读文件
	PeoInfo tmp = { 0 };
	while (fread(&tmp, sizeof(PeoInfo), 1, pf))
	{
		CheckCapacity(pc);
		pc->data[pc->sz] = tmp;
		pc->sz++;
	}
	//关闭文件
	fclose(pf);
	pf = NULL;
}
//初始化通讯录
void InitContact(Contact* pc)
{
	pc->data = (PeoInfo*)malloc(DEFAULT_SZ * sizeof(PeoInfo));
	if (pc->data == NULL)
	{
		printf("通讯录初始化失败，原因是：%s\n",strerror(errno));
		return;
	}
	pc->sz = 0;
	pc->capacity = DEFAULT_SZ;
	//加载文件的信息到通讯录中
	LoadContact(pc);
}
//判断空间是否满了
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
			printf("增容成功，当前容量是：%d\n", pc->capacity);
		}
	}
}
//增加通讯录联系人
void AddContact(Contact* pc)
{
	//判断要不要增容
	CheckCapacity(pc);
	//增加联系人信息
	printf("请输入联系人姓名：");
	scanf("%s", pc->data[pc->sz].name);
	printf("请输入联系人年龄：");
	scanf("%d", &pc->data[pc->sz].age);
	printf("请输入联系人性别：");
	scanf("%s", pc->data[pc->sz].sex);
	printf("请输入联系人电话：");
	scanf("%s", pc->data[pc->sz].tele);
	printf("请输入联系人住址：");
	scanf("%s", pc->data[pc->sz].addr);

	pc->sz++;
	printf("添加成功\n");
}

//显示联系人信息
void ShowContact(const Contact* pc)
{
	int i = 0;
	printf("%-10s %-5s %-5s %-13s %-20s\n",
		"姓名", "年龄", "性别", "电话", "住址");
	for (i = 0;i < pc->sz;i++)
	{
		printf("%-10s %-5d %-5s %-13s %-20s\n",
			pc->data[i].name, pc->data[i].age, pc->data[i].sex,
			pc->data[i].tele, pc->data[i].addr);
	}
}
//封装的查询名字的函数
//通过static修饰，是该函数只能在此源文件中使用。
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
//删除联系人信息
void DelContact(Contact* pc)
{
	//判断通讯录是否为空
	if (pc->sz == 0)
	{
		printf("通讯录为空，无法删除！\n");
		return;
	}
	//找到要删除的人的位置
	char search_name[MAX_NAME] = { 0 };
	printf("请输入要查找人的名字：");
	scanf("%s", search_name);
	//int pos = 0;//存储找到的位置
	int pos = FindByName(pc, search_name);
	/*int i = 0;//封装至一函数
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
		printf("要删除的人不存在！\n");
	}
	int i = 0;
	//删除pos位置上的数据
	for (i = pos;i < pc->sz - 1;i++)
	{
		pc->data[i] = pc->data[i + 1];//通过后一个元素依次覆盖
									  //原来前一个元素的位置来
									  //达到删除的目的
	}
	pc->sz--;
	printf("删除成功！\n");
}
//查找指定联系人
void SearchContact(const Contact* pc)
{
	char name[MAX_NAME] = { 0 };
	printf("请输入要查找人的名字：");
	scanf("%s", name);
	//通过函数查找
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("要查找的人不存在！\n");
		return;
	}
	//打印找到的人的信息
	printf("%-10s %-5s %-5s %-13s %-20s\n",
		"姓名", "年龄", "性别", "电话", "住址");
	printf("%-10s %-5d %-5s %-13s %-20s\n",
		pc->data[pos].name, pc->data[pos].age, pc->data[pos].sex,
		pc->data[pos].tele, pc->data[pos].addr);
}
//修改指定联系人
void ModifyContact(Contact* pc)
{
	char name[MAX_NAME] = { 0 };
	printf("请输入要修改人的名字：");
	scanf("%s", name);
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("要修改的人不存在！\n");
		return;
	}
	//修改信息，即重新输入信息即可
	printf("请输入联系人姓名：");
	scanf("%s", pc->data[pc->sz].name);
	printf("请输入联系人年龄：");
	scanf("%d", &pc->data[pc->sz].age);
	printf("请输入联系人性别：");
	scanf("%s", pc->data[pc->sz].sex);
	printf("请输入联系人电话：");
	scanf("%s", pc->data[pc->sz].tele);
	printf("请输入联系人住址：");
	scanf("%s", pc->data[pc->sz].addr);

	printf("修改成功！\n");
}
//qsort函数比较函数(通过名字排序)
int CmpByName(const void* e1, const void* e2)
{
	return strcmp(((PeoInfo*)e1)->name, ((PeoInfo*)e2)->name);
}
//排序通讯录信息
void SortContact(const Contact* pc)
{
	qsort(pc->data, pc->sz, sizeof(PeoInfo), CmpByName);
}
//销毁通讯录
void DestroyContact(Contact* pc)
{
	free(pc->data);
	pc->data = NULL;
	pc->capacity = 0;
	pc->sz = 0;
}
//保存通讯录
void SaveContact(Contact* pc)
{
	FILE* pf = fopen("contact.dat", "wb");
	if (pf == NULL)
	{
		perror("SaveContact::fopen");
		return;
	}
	//写数据
	int i = 0;
	for (i = 0;i < pc->sz;i++)
	{
		fwrite(pc->data+i,sizeof(struct PeoInfo),1,pf);
	}
	//关闭文件
	fclose(pf);
	pf = NULL;
	printf("保存成功！\n");
}