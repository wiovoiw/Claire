use studentsdb;
alter table student_info drop primary key;
alter table grade drop primary key;
alter table curriculum drop primary key;

create unique index cno_idx on curriculum(课程编号);

create index grade_idx on grade(分数);

create index grade_sid_cid_idx on grade(学号,课程编号);

show index from grade;

drop index grade_idx on grade;
show index from grade;

create view v_stu_c as select s.学号,姓名,课程编号 from student_info s,grade g where s.学号=g.学号;
select * from v_stu_c where 学号 = '0003';

create view v_stu_g as select s.学号,姓名,课程名称,分数 
from student_info s,grade g,curriculum c
where s.学号=g.学号 and g.课程编号=c.课程编号;
select avg(分数) 平均分 from v_stu_g where 学号='0001';

alter view v_stu_g as select 学号,姓名,性别 from student_info; 
select * from v_stu_g;

insert into v_stu_g (学号, 姓名, 性别) values ('0010','陈婷婷','女');

delete from v_stu_g where 学号='0010';

update grade set 分数=87 where 学号=
(select 学号 from v_stu_g where 姓名='张青平')and 课程编号=
(select 课程编号 from curriculum where 课程名称='高等数学');

drop view v_stu_c,v_stu_g;