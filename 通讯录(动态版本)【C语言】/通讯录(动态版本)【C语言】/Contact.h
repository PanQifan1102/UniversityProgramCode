#pragma once
//项目介绍
//通讯录动态版本可以满足随需求对通讯录的容量进行增加，
//以解除容量的限制。
// 每组信息包括：姓名、年龄、性别、电话、住址。功能
//包括联系人的增删查改及排序。

//文件组成
//test.c — 测试通讯录的相关功能及逻辑实现
//Contact.h — 通讯录引用的声明部分
//Contact.c — 通讯录的具体实现模块

//头文件的声明
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<errno.h>

//宏的定义
#define MAX 100
#define MAX_NAME 20
#define MAX_SEX 5
#define MAX_TELE 12
#define MAX_ADDR 30
#define DEFAULT_SZ 3
#define INC_SZ 2

//各类型的创建及声明
//通讯录的信息组成
typedef struct PeoInfo
{
	char name[MAX];
	int age;
	char sex[MAX_SEX];
	char tele[MAX_TELE];
	char addr[MAX_ADDR];
}PeoInfo;
////通讯录所用数据打包
////静态版本
//typedef struct Contact
//{
//	PeoInfo data[100];//通讯录容量
//	int sz;//通讯录当前容量
//}Contact, * pContact;
//动态版本
//默认能够存放三个人的信息
//不够的话，每次增加2个人的信息
typedef struct Contact
{
	PeoInfo* data;//data指向了存放数据的空间
	int sz;//记录通讯录中有效信息的个数
	int capacity;//记录通讯录当前的最大容量
}Contact;
//函数的声明
//初始化通讯录
void InitContact(Contact* pc);
//增加通讯录联系人
void AddContact(Contact* pc);
//显示联系人信息
void ShowContact(const Contact* pc);
//删除联系人信息
void DelContact(Contact* pc);
//查找指定联系人
void SearchContact(const Contact* pc);
//修改指定联系人
void ModifyContact(Contact* pc);
//排序通讯录信息
void SortContact(const Contact* pc);
//销毁通讯录
void DestroyContact(Contact* pc);
//保存通讯录
void SaveContact(Contact* pc);