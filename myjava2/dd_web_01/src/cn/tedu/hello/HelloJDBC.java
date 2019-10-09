
package cn.tedu.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 1.这个类用来做第一个jdbc的应用
 */
public class HelloJDBC {
	//单元测试方法hello
	//@Test + void
	/*
	 * 1.注册驱动
	 * 2.获取数据库连接
	 * 3.获取传输器
	 * 4.执行SQL
	 * 5.遍历结果集
	 * 6.释放资源 
	 */
	@Test
	public void hello() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			//1.注册驱动 com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
			
			//2.获取数据库连接
			//连接数据库的url
			String url="jdbc:mysql://localhost:3306/jt_db";
			//连接数据库的用户名
			String user="root";
			//连接数据库的密码
			String password="Aa123456";
			//java.sql.Connection
			conn = DriverManager.getConnection(url, user, password);
			
			//3.获取传输器 java.sql.Statement
			st = conn.createStatement();
			
			//4.执行SQL，查询account表
			String sql = "select * from account";
			rs = st.executeQuery(sql);
			
			//5.遍历结果集
			while(rs.next()) {
				//根据索引列查询数据
				String id = rs.getString(1);
				//通过字段名称获取到字段的值
				//String id2 = rs.getString("id");
				//根据索引列查询name的值
				String name = rs.getString(2);
				//根据索引列查询money的值
				String money = rs.getString(3);
				System.out.println(id+name+money);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.释放资源,正着开，倒着关
			if(rs != null) {//防止空指针异常
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					rs = null;
				}
			}
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
	
}