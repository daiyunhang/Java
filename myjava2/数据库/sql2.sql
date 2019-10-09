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
-- mysql第二天------------------------------------------------------------------
mysql -uroot -p
Aa123456
-- 进入hr库
use hr;

-- 50部门,工资大于8000的员工,按工资降序排列
select employee_id,first_name,salary,department_id
from employees
where department_id=50 and salary>=8000
order by salary desc;


-- 电话号码 phone_number 包含'44',并把44替换成88
-- select employee_id,phone_number,first_name,salary,department_id
-- from employees
-- where phone_number like '%44%';
select employee_id,phone_number,replace(phone_number,'44','88')
from employees
where phone_number like '%44%';


-- manager_id,主管id是100,200,122的人数
select count(*)
from employees
where manager_id in(100,120,122);

-- 按主管id分组,求每个主管的手下人数
select manager_id, count(*)
from employees
where manager_id is not null
group by manager_id;

-- 用来对多行函数结果进行过滤
-- having 和 where 作用相同,都是条件过滤
-- where 过滤普通条件,最早执行
-- having 过滤多行函数结果,分组,求完多行函数后,才执行
select count(*) c
from employees
group by manager_id
having c=1;


-- 平均工资小于等于5000的岗位代码
select job_id,avg(salary) a
from employees
group by job_id
having a<=5000;


-- 工资小于平均工资
-- select avg(salary) from employees;
select employee_id,first_name,salary
from employees
where salary < (select avg(salary) from employees)
-- order by salary desc;

-- 每个部门,拿最高工资的员工
-- 每个部门的最高工资值
select department_id,max(salary) m
from employees
where department_id is not null
group by department_id;

select employee_id,first_name,salary,department_id
from employees
where (department_id,salary) in (
    select department_id,max(salary) m
    from employees
    where department_id is not null
    group by department_id
);

-- 只有一个人的部门,查询这些员工
-- 1.按部门分组求人数,过滤只有一个人的部门
-- 2.用部门id过滤查询员工
select department_id
from employees
where department_id is not null
group by department_id
having count(*)=1;

select employee_id,first_name,salary,department_id
from employees
where department_id in(
    select department_id
    from employees
    where department_id is not null
    group by department_id
    having count(*)=1
);

-- 从查询的查询的结果,再查询
-- select ... from(select ...) t
-- 0.平均工资最低的工作岗位代码
-- 1.按工作job_id分组求平均工资
-- 2.平均工资最小值
-- 3.用平均工资最小值,过滤岗位代码
select job_id,avg(salary) a
from employees
group by job_id;

-- 求出最小工资
select min(a)
from (
    select job_id,avg(salary) a
    from employees
    group by job_id
) t;

select job_id,avg(salary) a
from employees
group by job_id
having a=(
    select min(a)
    from (
        select job_id,avg(salary) a
        from employees
        group by job_id
    ) t 
);

-- 手下人数最多的主管id
-- 1.按 manager_id 分组求人数
-- 2.求人数的最大值
select manager_id,count(*) c
from employees
where manager_id is not null
group by manager_id
order by c;

select max(c)
from (
    select manager_id,count(*) c
    from employees
    where manager_id is not null
    group by manager_id
    order by c
) t;

select manager_id,count(*) c
from employees
where manager_id is not null
group by manager_id
having c=(
select max(c)
    from (
        select manager_id,count(*) c
        from employees
        where manager_id is not null
        group by manager_id
        order by c
    ) t  
)
order by c;


-- 约束  
-- 主键5.1
-- 如果没有db1库
create database db1 charset utf8;
-- 有db1库直接进入
use db1;
-- 创建学生库
create table xuesheng(
    id int primary key,
    stu_num int,
    name varchar(20)
);
-- 告诉服务器,客户端使用的什么字符编码
set names gbk;

insert into xuesheng(id,name)
values(1,'张三'),(2,'李四');
-- 重复 违反主键约束
insert into xuesheng(id,name)
values(1,'王五');


-- 5.2 自增主键 auto_increment
create table xuesheng(
    id int primary key auto_increment,
    ....
);
-- 修改为自增主键
alter table xuesheng 
modify id int auto_increment;
-- 插入数据
insert into xuesheng(name)
values('李四'),('王五'),('赵六');
-- 查询
select * from xuesheng;

-- 5.2.1 获得刚刚产生的自增值
-- last_insert_id() 只获得当前会话产生的自增值
insert into xuesheng(name)
values('赵安');
select last_insert_id();

-- 5.3 外键
-- 限制一个字段,只能取指定的主键字段中,存在的值
create table banji(
    id int primary key auto_increment,
    name varchar(20)
);

-- 修改学生表,添加外键字段 ban_id,
-- 引用banji表的主键id
alter table xuesheng 
add(
    ban_id int,
    foreign key(ban_id) references banji(id)
);

-- 班级表插入班级数据
insert into banji(name)
values('A'),('B');
select * from banji;

-- 让学生1,2,3在1班
update xuesheng set ban_id=1
where id in(1,2,3);
--让学会说呢过4,5在2班
update xuesheng set ban_id=2
where id in(4,5);

-- 5.4 非空
not null
-- 5.5 唯一 自动创建索引
unique not null-- 不重复
-- 5.6 检查
-- mysql不支持 mariadb 支持检查约束
check(age>=7 && age<=60),
check(gender in('M','F'))

--------------------------------------------------
-- 多表连接查询
 countries    
 departments  
 employees    
 job_history  
 jobs         
 locations    
 regions
use hr;
select * from departments;

-- 查询员工,显示员工的部门名
select e.employee_id,e.first_name,e.salary,
       d.department_id,d.department_name
from employees e,departments d
where e.department_id = d.department_id;

-- 地区表
select * from locations;

-- 查询部门,显示部门的城市
select d.department_id,d.department_name,
       l.city
from departments d,locations l
where d.location_id = l.location_id;

-- 查询部门,显示部门经理名
select d.department_id,d.department_name,
       e.first_name
from departments d,employees e
where d.manager_id = e.employee_id;

-- 查询员工,显示员工上司(主管)名
select e1.employee_id,e1.first_name,e1.salary,
       e2.first_name mar
from employees e1,employees e2
where e1.manager_id = e2.employee_id;


--------------------------------------------------------
-- 外连接 
-- 查询所有部门,显示部门经理,没有经理显示null
select d.department_id,d.department_name,
       e.first_name
from departments d
left join employees e
on(d.manager_id=e.employee_id);  

-- 查询107个员工,显示部门名和城市
select e.employee_id,e.first_name,e.salary,
       d.department_id,
       l.city
from employees e
    left join departments d 
    on(e.department_id=d.department_id)
    left join locations l
    on(d.location_id=l.location_id);


--------------------------------------------------------
-- 事务
-- 8.1启动事务
begin;
start transcation
事务启动后,执行的数据增删改操作
会暂时记录在一个日志文件中

-- 8.3提交事务
commit
事务日志中记录的数据操作,在数据表中生效
清空日志文件

-- 8.3回滚事务
rollback
清空日志

-- 
use db1;
select * from banji;


-- 会话1
insert into banji(name)
values('C');
update banji set
name = 'Z' 
where id=1;

commit;


-- 会话2
select * from banji;
commit;
select * from banji;

----------------------

-- 会话1
begin;
update banji set
name = 'Y' 
where id=1;
--
rollback;
-- 会话2
begin;
update banji set
name = 'X' 
where id=1;
commit;
select * from banji;

----------------------------------
--数据访问冲突问题
set tx_isolation='read-uncommitted'; -- 读取未提交
set tx_isolation='read-committed'; -- 
set tx_isolation='repeatable-read';
set tx_isolation='serialiable';

-- 会话1
rollback;
-- 设置隔离级别 
set tx_isolation='read-uncommitted';
begin;
insert into banji(name)
values('E');
update banji set
name = 'V' 
where id=1;
rollback;

-- 会话2
rollback;
-- 设置隔离级别 
set tx_isolation='read-uncommitted';
begin;
select * from banji;


-- 会话1
rollback;
set tx_isolation='read-committed';
begin;
select * from banji;
update banji set
name = 'T' 
where id=1;
commit;

-- 会话2
rollback;
set tx_isolation='read-committed';
begin;
select * from banji;


-- 会话1
rollback;
set tx_isolation='repeatable-read';
begin;
insert into banji(name)
values('F');
update banji set
name = 'S' 
where id=1;
commit;


-- 会话2
rollback;
set tx_isolation='repeatable-read';
begin;
select * from banji;
update banji set
name = concat('*',name); 
select * from banji;

-- 会话1
rollback;
begin;

delete from xuesheng;
delete from banji
where id in(1,2);
commit;

-- 会话2
rollback;
begin;
select * from banji;
update banji set 
name=concat('#',name);
select * from banji;
commit;
select * from banji;

--------------------------------------结束
exit;




























