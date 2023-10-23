use studentsdb;
select 学号, 姓名, 出生日期 from student_info;
select 姓名, 家庭住址 from student_info where student_info.学号="0002";
select 姓名, 出生日期 from student_info where 性别="女" and 出生日期 > 1995;

select 学号, 课程编号, 分数 from grade where grade.分数 between 70 and 80;
select avg(分数) from grade where grade.课程编号="0002";
select count(*)选课人数, count(分数)有成绩的人 from grade where grade.课程编号="0003";
select 姓名, 出生日期 from student_info order by 出生日期 desc;
select 学号, 姓名 from student_info where 姓名 like "张%";

select 学号, 姓名, 性别, 出生日期, 家庭住址 from student_info order by 性别 desc, 学号 desc;
select 学号, avg(分数) from grade group by 学号;
select 学号, 姓名 from student_info where 姓名 like "张%"
union
select 学号, 姓名 from student_info where 姓名 like "刘%";

select 姓名, 出生日期 from student_info where 性别 = (select 性别 from student_info where 姓名="刘东阳");
select 学号, 姓名, 性别 from student_info where 学号 in (select 学号 from grade where 课程编号 in ("0002", "0005"));
select 课程编号, 分数 from grade where 学号="0001" and 分数 > any(select 分数 from grade where 学号="0002");
select 课程编号, 分数 from grade where 学号="0001" and 分数 > all(select 分数 from grade where 学号="0002");

select student_info.学号, 姓名, 分数 from student_info, grade where student_info.学号 = grade.学号 and 分数 between 80 and 90;

select student_info.学号,姓名,分数 from student_info 
inner join grade on student_info.学号 = grade.学号
inner join curriculum on grade.课程编号 = curriculum.课程编号  
where 课程名称 = "数据库原理及应用";

select student_info.学号, 姓名, MAX(分数) 最高成绩 from student_info, grade
where student_info.学号 = grade.学号 group by student_info.学号; 

select student_info.学号, 姓名, SUM(分数) 总成绩 from student_info 
left outer join grade on student_info.学号 = grade.学号 group by student_info.学号; 

insert into grade values('0004','0006',76);  
select grade.课程编号, 课程名称, COUNT(*) 选修人数 from curriculum
right outer join grade on grade.课程编号 = curriculum.课程编号 group by grade.课程编号; 
