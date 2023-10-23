create database if not exists studentsdb;
use studentsdb;
create table if not exists student_info(
学号 char(4) not null primary key,
姓名 char(8) not null,
性别 char(2) null,
出生日期 date null,
家庭住址 varchar(50) null
);
desc student_info;

create table if not exists curriculum(
课程编号 char(4) not null primary key,
课程名称 varchar(50) null,
学分 int null
);
desc curriculum;

create table if not exists grade(
学号 char(4) not null,
课程编号 char(4) not null,
分数 int null,
primary key(学号,课程编号)
);
desc grade;

INSERT INTO student_info VALUES('0001','张青平','男','2000-10-01','衡阳市东风路77号');
INSERT INTO student_info VALUES('0002','刘东阳','男','1998-12-09','东阳市八一北路33号');
INSERT INTO student_info VALUES('0008','张玲珑','女','1997-12-24','滨江市新建路97号');
INSERT INTO student_info VALUES('0003','马晓夏','女','1995-05-12','长岭市五一路763号'); 
INSERT INTO student_info VALUES('0004','钱忠理','男','1994-09-23','滨海市洞庭大道279号');
INSERT INTO student_info VALUES('0005','孙海洋','男','1995-04-03','长岛市解放路27号');
INSERT INTO student_info VALUES('0006','郭小斌','男','1997-11-10','南山市红旗路113号');
INSERT INTO student_info VALUES('0007','肖月玲','女','1996-12-07','东方市南京路11号');
select*from student_info;

INSERT INTO curriculum VALUES('0001','计算机应用基础',2);
INSERT INTO curriculum VALUES('0002','C语言程序设计',2);
INSERT INTO curriculum VALUES('0003','数据库原理及应用',2);
INSERT INTO curriculum VALUES('0004','英语',4);
INSERT INTO curriculum VALUES('0005','高等数学',4);
select*from curriculum;

INSERT INTO grade VALUES('0001','0001',80);
INSERT INTO grade VALUES('0001','0002',91);
INSERT INTO grade VALUES('0001','0003',88);
INSERT INTO grade VALUES('0001','0004',85);
INSERT INTO grade VALUES('0001','0005',77);
INSERT INTO grade VALUES('0002','0001',73);
INSERT INTO grade VALUES('0002','0002',68);
INSERT INTO grade VALUES('0002','0003',80);
INSERT INTO grade VALUES('0002','0004',79);
INSERT INTO grade VALUES('0002','0005',73);
INSERT INTO grade VALUES('0003','0001',84);
INSERT INTO grade VALUES('0003','0002',92);
INSERT INTO grade VALUES('0003','0003',81);
INSERT INTO grade VALUES('0003','0004',82);
INSERT INTO grade VALUES('0003','0005',75);
select*from grade;

alter table curriculum modify 课程名称 varchar(50) null;
desc curriculum;

alter table grade modify 分数 decimal(5,2);
desc grade;

alter table student_info add 备注 varchar(50);
desc student_info;

create database if not exists studb;
use studb;
create table stu as select*from studentsdb.student_info;
desc stu;

set sql_safe_updates=0;
delete from stu where 学号 = "0004";
select*from stu;

update stu set 家庭住址 = "滨江市新建路96号" where 学号 = "0002";
select*from stu;

alter table stu drop column 备注;
select*from stu;

drop table if exists stu;

drop database if exists studb;