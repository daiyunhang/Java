
mysql -uroot -p
Aa123456
create database jt_db default character set utf8;
show databases;
use jt_db;

-- 1.1 创建account表 id自增
create table account(
    id int primary key auto_increment,
    name varchar(50),
    money double
);
show tables;

-- 1.2 往account表中插入两条数据
insert into account 
values(null,'wanght',100); 
select * from account;

insert into account 
values(null,'xiongda',1000); 
select * from account;

-- 1.3 在jt_db表中创建User表,有id,username,password字段
create table user(
    id int primary key auto_increment,
    username varchar(50),
    password varchar(50)
);
show tables;

-- 1.4 user表插入两条数据
insert into user 
values(null,'guangtouqiang','123');
select * from user;

insert into user values(null,'chenzs','123');
select * from user;


-- 1.5 创建dept 表,有id,name字段
create table dept(
    id int primary key auto_increment,
    name varchar(50)
);
show tables;

-- 1.6 在dept 插入两条记录
insert into dept values(null,'dept1');
insert into dept values(null,'dept2');
select * from dept;


-- 2,3.1 JDBC原理,JDBC概述
java database connectivity, java数据库连接.
专用用来通过一段java代码操作数据库的一门技术

-- 3.2 如何使用jdbc

-- 3.2.1 需求

通过jdbc技术，查询account表中的所有数据



-- 3.2.2 开发步骤
创建dd_web_01的动态web工程，创建HelloJDBC类，创建hello方法
-------------------------------------------------------------------------------
-- 4.1 注册驱动  -------------------优化----------------------
DriverManager.registerDriver(new Driver());
缺点：
    1.驱动名和程序产生了紧耦合的关系
    2.使得驱动被注册了两次
解决方案：
    Class.forName("com.mysql.jdbc.Driver");

-- 4.2 获取数据库连接
    jdbc:mysql://localhost:3306/jt_db
    ----------   --------- ----  ---
      协议名         域名  端口号  数据库名字

-- 简写:
    jdbc:mysql:///jt_db
--前提：必须访问本地数据库服务器 localhost+必须使用默认端口号3306

-- 4.3 数据库连接对象 Connection
-- 4.3.1 作用：
    通过三个数据库的链接参数，链接到数据库进行数据库的管理
-- 4.3.2 常用方法
    createStatement() ------ 获取传输器对象
    prepareStatement() ----- 获取带有预编译效果的传输器对象

-- 4.4 传输器对象 Statement
-- 4.4.1 作用
    用来执行SQL
-- 4.4.2 常用方法
    executeQuery() ------ 执行查询的SQL
    execteUpdate() ------ 执行增删改的SQL
-- 4.5 结果集对象 ResultSet
-- 4.5.1 作用
    用来封装SQL执行完的数据
-- 4.5.2 常用方法
    Next() ------ 查询结果集中是否有数据，指针的效果
    getString(String column) ------ 根据指定列名获取数据
    getString(int index) ----------根据列的索引获取数据
-- 4.6 关闭资源
-- 4.6.1
    在jdbc中,资源是十分稀缺的,需要我们每次使用完之后必须释放资源.
    当我们在释放资源时,有可能会发生异常,为了保证资源释放一定会被执行
    需要把释放资源的代码放入finally代码块中
-- 4.6.2 现状
    //6.释放资源,正着开，倒着关
    rs.close();
    st.close();
    conn.close();
-- 4.6.3 改造




-- 5 JDBC增删改查
-- 5.1 新增
    向user表中插入一条记录
-- 5.2 修改
    修改account表中id为1的记录,money为200

-- 5.3 删除
    删除user表里id为4的记录

-- 6 JDBC
    在jdbc的开发中,存在大量重复的代码,讲这些重复的代码提取出来,
    封装起来,提高代码的复用性,简化开发.
    --
    私有化构造函数
    提供静态方法 getConnection 用来对外提供数据库连接对象
    提供静态方法 close 用来释放资源






























































































