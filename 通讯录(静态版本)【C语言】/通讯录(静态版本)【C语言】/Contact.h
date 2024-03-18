#pragma once
//��Ŀ����
//ͨѶ¼��̬�汾��������СΪ100�����԰���100����Ϣ��
// ÿ����Ϣ���������������䡢�Ա𡢵绰��סַ������
//������ϵ�˵���ɾ��ļ�����

//�ļ����
//test.c �� ����ͨѶ¼����ع��ܼ��߼�ʵ��
//Contact.h �� ͨѶ¼���õ���������
//Contact.c �� ͨѶ¼�ľ���ʵ��ģ��

//ͷ�ļ�������
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//��Ķ���
#define MAX 100
#define MAX_NAME 20
#define MAX_SEX 5
#define MAX_TELE 12
#define MAX_ADDR 30

//�����͵Ĵ���������
//ͨѶ¼����Ϣ���
typedef struct PeoInfo
{
	char name[MAX];
	int age;
	char sex[MAX_SEX];
	char tele[MAX_TELE];
	char addr[MAX_ADDR];
}PeoInfo;
//ͨѶ¼�������ݴ��
typedef struct Contact
{
	PeoInfo data[100];//ͨѶ¼����
	int sz;//ͨѶ¼��ǰ����
}Contact,*pContact;

//����������
//��ʼ��ͨѶ¼
void InitContact(Contact *pc);
//����ͨѶ¼��ϵ��
void AddContact(Contact *pc);
//��ʾ��ϵ����Ϣ
void ShowContact(const Contact *pc);
//ɾ����ϵ����Ϣ
void DelContact(Contact *pc);
//����ָ����ϵ��
void SearchContact(const Contact* pc);
//�޸�ָ����ϵ��
void ModifyContact(Contact* pc);
//����ͨѶ¼��Ϣ
void SortContact(const Contact* pc);