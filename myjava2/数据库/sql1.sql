-- 如果存在删除 db1 
-- 删除db1库
drop database if exists db1; 
-- 重新创建db1库
create database db1 charset utf8;
-- 查看丶进入db1库
show databases;
use db1;



-- 删除stu学生表
drop table if exists stu;
-- 创建sth表
create table stu(
    id int,
    name varchar(20),
    gender char(1),
    birthday date
);
-- 查看表结构
desc stu;

-- 中文
-- 先告诉服务器,客户端是什么编码
-- 连接断开之前,服务器可以记住这个编码
set names gbk;

-- 插入数据
insert into stu
values(6,'张三','男','1996-8-4');

-- 查询stu表格的数据
select * from stu;

-- 插入id,name
insert into stu(id, name)
values(7, '李四');

-- 插入多行
insert into stu(id, name)
values(8, '王五'), (9, '赵六'), (10, '小骨');

-- 查询stu表格的数据
select * from stu;

-- 对李四进行修改 
-- 把7,李四的性别和生日
-- 修改成 '女','1998-8-4'
update stu 
set gender = '女', birthday='1998-8-4'
where id=7;
select * from stu;

-- 删除 id>8 的数据
delete from stu
where id>8;
select * from stu;

-- 查询 select
-- 查询指定的字段
select name, gender from stu;


-- 准备测试数据
-- hr_mysql.sql 放在F:\java\myjava2目录
-- sql脚本文件,
-- 建库丶建表丶插入数据库的sql代码
-- 执行这个文件中的sql代码
source F:\java\myjava2\hr_mysql.sql -- 没有分号
 employee_id | 
 first_name  | 
 last_name   | 
 email    | 
 phone_number | 
 hire_date  | 
 job_id     | 
 salary   | 
 commission_pct | 
 manager_id | 
 department_id |
-- 查看表
show tables;
-- 员工表表结构
desc employees;
-- 员工表数据
select * from employees;

select employee_id, first_name, salary, department_id
from employees;

-- 员工id是122
select employee_id, first_name, salary, department_id
from employees
where employee_id=122;

-- 部门编号department_id是30
select employee_id, first_name, salary, department_id
from employees
where department_id=30;

-- 工作岗位代码job_id是'IT_PROG'
select employee_id, first_name, salary, department_id
from employees
where job_id='IT_PROG';
--
select employee_id, first_name, salary, department_id, job_id
from employees
where job_id='IT_PROG';

--部门编号department_id 不是50
select employee_id, first_name, salary, department_id
from employees
where department_id<>50;

-- 工资salary>5000
select employee_id, first_name, salary, department_id
from employees
where salary>5000;

-- 工资范围[5000, 8000]
select employee_id, first_name, salary, department_id
from employees
where salary>=5000 and salary<=8000;
--
select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 8000;

-- employee_id是 120, 122, 100, 150
select employee_id, first_name, salary, department_id
from employees
where employee_id in(120,122,100,150);
--
select employee_id, first_name, salary, department_id
from employees
where employee_id=120 or employee_id=122 or employee_id=100 or employee_id=150;

-- 没有部门的员工,department_id 是null
select employee_id, first_name, salary, department_id
from employees
where department_id is null;

-- 有提成是员工, commission_pct 不是null
select employee_id, first_name, salary, department_id
from employees
where commission_pct is not null;

-- ------------------------------------------

-- first_name 中包含 en
select employee_id, first_name, salary, department_id
from employees
where first_name like '%en%';

-- first_name 第3丶4个字符是en
select employee_id, first_name, salary, department_id
from employees
where first_name like '__en%';

-- ------------------------------------------

-- 查询所有部门 employee_id 
select distinct department_id from employees
where department_id is not null;

-- 查询50部门员工,按工资降序
-- 降序 desc , 升序 asc
select employee_id, first_name, salary, department_id
from employees
where department_id=50
order by salary desc;


-- 所有员工,按部门升序,相同部门按工资降序
select employee_id, first_name, salary, department_id
from employees
order by department_id asc, first_name desc;


-- ---------------------------------------------------------
-- 两个单引号转义成一个单引号
use db1;
insert into stu(id,name)
values(6433, 'I''m Xxx');
select * from stu;


-- sql注入攻击
-- 密码输入 1'or'1'='1  为真绝对成立
-- --------------------------------------------------------------

use hr;
-- first_name 和 last_name 首字母相同
select employee_id, first_name, salary, department_id
from employees
-- where left(first_name,1)=left(last_name,1);
where substring(first_name,1,1)=substring(last_name,1,1);


-- first_name 和 last_name 连接起来,再对齐中间的空格
select concat(lpad(first_name,20,' '),' ',last_name)
from employees;


-- 工资上涨 11.31%,向上取整到10位
select employee_id, first_name, salary, ceil(salary*1.1131/10)*10
from employees;

-- 所有员工随机排序
select employee_id,first_name,salary,department_id
from employees
order by rand();

-- 查询系统的当前时间
select now();

-- 1997年入职的所有员工+ 排序y 
select employee_id,first_name,hire_date y
from employees
-- where hire_date between '1997-1-1' and '1997-12-31';
where extract(year from hire_date)=1997
order by y;

-- 查询员工入职多少年 + 排序y
select employee_id,first_name,hire_date,
datediff(now(),hire_date)/365 y
from employees
order by y;

-- 年薪*提成
select employee_id,first_name,salary,salary*12*(1+ifnull(commission_pct,0)) t
from employees
order by t desc;

-- 多行函数,不能与单行(普通)函数一起使用,数据会乱
-- 查询最低工资值 
select employee_id,first_name, min(salary) 
from employees;

-- 多行函数可以一起使用
select sum(salary),avg(salary),max(salary),min(salary),count(salary)
from employees;


-- 每个部门的平均工资
select department_id, avg(salary)
from employees
where department_id is not null
group by department_id;

-- 每个工作岗位job_id的人数
select job_id, count(*)
from employees
group by job_id;




































