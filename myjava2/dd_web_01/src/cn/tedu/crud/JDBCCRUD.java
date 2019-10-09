package cn.tedu.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 这个类用来完成jdbc的增删改查 
 */
public class JDBCCRUD {
	//向user表中插入一条记录
	@Test
	public void add() {
		Connection conn = null;
		Statement st = null;
		/*
		 * 1.注册驱动
		 * 2.获取数据库连接
		 * 3.获取传输器
		 * 4.执行SQL
		 * 5.遍历结果集
		 * 6.释放资源 
		 */
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.获取数据库连接
			String url="jdbc:mysql://localhost:3306/jt_db";
			String user="root";
			String password="Aa123456";
			conn = DriverManager.getConnection(url, user, password);

			//3.获取传输器
			st = conn.createStatement();
			
			//4.执行SQL
			String sql = "insert into user values(null,'dyh','Aa123456')";
			int rows = st.executeUpdate(sql);
			
			//5.遍历结果集
			System.out.println(rows);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.释放资源,正着开，倒着关
			if(st != null) {//防止空指针异常
				try {
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					st = null;
				}
			}
			if(conn != null) {//防止空指针异常
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
	}
	
	//修改account表中id为1的记录,money为200
	@Test
	public void update() {
		Connection conn = null;
		Statement st = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			String url="jdbc:mysql://localhost:3306/jt_db";
			String user="root";
			String password="Aa123456";
			conn = DriverManager.getConnection(url, user, password);
			//3.获取传输器
			st = conn.createStatement();
			//4.执行SQL
			String sql = "update account set money=200 where id=1";
			int rows = st.executeUpdate(sql);
			//5.遍历结果集
			System.out.println(rows);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//6.释放资源,正着开，倒着关
			if(st != null) {//防止空指针异常
				try {
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					st = null;
				}
			}
			if(conn != null) {//防止空指针异常
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
	}

	//删除user表里id为4的记录
	@Test
	public void del() {
		Connection conn = null;
		Statement st = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			String url="jdbc:mysql:///jt_db";
			String user="root";
			String password="Aa123456";
			conn = DriverManager.getConnection(url, user, password);
			//3.获取传输器
			st = conn.createStatement();
			//4.执行SQL
			String sql = "delete from user where id=4";
			int rows = st.executeUpdate(sql);
			//5.遍历结果集
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.释放资源,正着开,倒着关
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					st = null;
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
	}
	
}
