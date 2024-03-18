/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   id                   int not null,
   cus_id               int not null,
   address              char(30) not null
);

/*==============================================================*/
/* Table: catering                                              */
/*==============================================================*/
create table catering
(
   id                   int not null,
   name                 char(20) not null,
   kind_id              int not null,
   size                 char(10),
   price                float not null
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   int not null,
   name                 char(10) not null,
   telephone_num        int not null,
   address_id           int
);

/*==============================================================*/
/* Table: dep                                                   */
/*==============================================================*/
create table dep
(
   id                   int not null,
   name                 char(5) not null,
   leader_id            int not null
);

/*==============================================================*/
/* Table: dessert                                               */
/*==============================================================*/
create table dessert
(
   id                   int not null,
   name                 char(20) not null,
   kind_id              int not null,
   size                 char(10),
   price                float not null
);

/*==============================================================*/
/* Table: drink                                                 */
/*==============================================================*/
create table drink
(
   id                   int not null,
   name                 char(20) not null,
   kind_id              int not null,
   size1                char(10),
   size2                char(10),
   price                float not null
);

/*==============================================================*/
/* Table: emp                                                   */
/*==============================================================*/
create table emp
(
   id                   int not null,
   name                 char(10) not null,
   sex                  char(2) not null,
   sal                  int not null,
   job_time             int not null,
   dep_id               int not null
);

/*==============================================================*/
/* Table: main_food                                             */
/*==============================================================*/
create table main_food
(
   id                   int not null,
   name                 char(20) not null,
   kind_id              int not null,
   size                 char(10),
   price                float not null
);

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table order_table
(
   id                   int not null,
   emp_id               int not null,
   cus_id               int not null,
   time                 datetime not null,
   address_id           int,
   price                float not null,
   food_id              int not null
);

/*==============================================================*/
/* Table: "kind_table"                                                  */
/*==============================================================*/
create table if not exists kind_table
(
   id                   int not null,
   name                   char(5) not null
);

/*=============================================================*/
/*对数据库的表进行数据插入                                     */
/*=============================================================*/
use online_shopping;#进入相应的数据库
show tables;
## 对员工表(emp)进行数据插入
select * from emp;
insert into emp (id,name,sex,sal,job_time,dep_id) values 
(1,'张三','男',9000.00,2022-7-9,1),
(2,'李四','女',9000.00,2022-7-9,1),
(3,'王五','男',8000.00,2022-8-9,2),
(4,'赵六','女',6000.00,2022-10-2,2),
(5,'张三三','男',2000.00,2022-10-4,2);

## 对部门表(dep)进行数据插入
select * from dep;
insert into dep (id,name,leader_id) values
(1,'管理部',1),
(2,'餐饮部',3);

## 对主食表(main_food)进行数据插入
select * from main_food;
insert into main_food (id,name,kind_id,price) values
(1,'香辣鸡腿堡',1,21.50),
(2,'新奥尔良烤鸡腿堡',1,22.00),
(3,'老北京鸡肉卷',2,20.50),
(4,'芙蓉荟蔬汤',3,11.00),
(5,'川香鸡肉饭',4,23.00),
(6,'深海鳕鱼堡',1,21.50);

## 对配餐表(catering)进行数据插入
select * from catering;
insert into catering (id,name,kind_id,size,price) values
(1,'劲爆鸡米花',5,'小份',14.00),
(2,'劲爆鸡米花',5,'大份',17.00),
(3,'香辣鸡腿',5,'小份',14.50),
(4,'香辣鸡腿',5,'大份',18.00),
(5,'薯条',6,'小份',11.00),
(6,'薯条',6,'大份',16.00),
(7,'醇香土豆泥',6,'null',9.50),
(8,'上校鸡块',5,'null',14.50);

## 对饮品表(drink)进行数据插入
select * from drink;
insert into drink (id,name,kind_id,size1,size2,price) values
(1,'黑糖珍珠奶茶',7,'大份','热',21.00),
(2,'黑糖珍珠奶茶',7,'小份','常温',17.00),
(3,'百事可乐',8,'大份','冰',13.00),
(4,'百事可乐',8,'大份','常温',13.00),
(5,'百事可乐',8,'小份','冰',10.00),
(6,'百事可乐',8,'小份','常温',10.00),
(7,'泡泡牛奶',9,'null','null',15.00),
(8,'美式咖啡',10,'大份','null',18.00),
(9,'美式咖啡',10,'小份','null',15.00),
(10,'雪顶咖啡',10,'null','null',16.50),
(11,'拿铁',10,'大份','冰',22.00),
(12,'拿铁',10,'大份','热',22.00),
(13,'拿铁',10,'小份','冰',18.00),
(14,'拿铁',10,'小份','热',18.00);

## 对甜品表(dessert)进行数据插入
select * from dessert;
insert into dessert (id,name,kind_id,size,price) values
(1,'红豆派',11,null,9), 
(2,'葡式蛋挞',11,null,10.50), 
(3,'巴克斯蛋糕',11,null,19.9), 
(4,'华夫饼',11,null,6), 
(5,'甜筒',12,null,8.5),
(6,'草莓圣代',12,null,14.5), 
(7,'巧克力圣代',12,null,14.5); 

## 对类别表(kind_table)进行数据插入
select * from kind_table;
insert into kind_table (id,name) values
(1,'汉堡'),
(2,'肉卷'),
(3,'汤'),
(4,'米饭'),
(5,'炸鸡'),
(6,'小食'),
(7,'奶茶'),
(8,'可乐'),
(9,'牛奶'),
(10,'咖啡'),
(11,'甜品'),
(12,'冰淇淋');

## 对用户信息表(customer)进行数据插入
select * from customer;
insert into customer (id,name,telephone_num,address_id) values
(1,'春风',1802,1),
(2,'夏至',1372,2),
(3,'秋风',1533,3),
(4,'冬至',1382,null);

## 对地址表(address)进行数据插入
select* from address;
insert into address (id,cus_id,address) values
(1,1,'XXX-XX-XXX-021'),
(2,2,'XXX-XX-XXX-022'),
(3,2,'XXX-XX-XXX-023');

## 对订单表()进行数据插入
select * from order_table;
insert into order_table (id,emp_id,cus_id,time,address_id,price,food_id) values
(1,4,2,'2023-1-1 14:37:14',1,100,1);

/*============================================================================*/
/*主要功能                                                                    */
/*============================================================================*/
select * from address;
select * from catering;
select * from customer;
select * from dep;
select * from dessert;
select * from drink;
select * from emp;
select * from kind_table;
select * from main_food;
select * from order_table;

## 查看给表的食品名称及价格(以主食表为例)
select name,price from main_food;

## 若顾客想买咖啡，则查询语句
select name,size1,size2,price from drink where kind_id = 10;

## 查看顾客的信息
select customer.id,customer.name,telephone_num,address 
from customer right join address 
on address.cus_id = customer.id;

## 构建套餐信息(如：大份炸鸡+大份可乐)
select catering.name,drink.name
from catering,drink
where (catering.kind_id = 5 and drink.kind_id = 8) 
and (size1 = '大份' and size2 = '冰') 
and catering.size != '小份';

## 查询员工的所在部门
select emp.name,dep.name
from emp,dep where emp.dep_id = dep.id;

