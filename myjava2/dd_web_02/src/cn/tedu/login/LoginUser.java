package cn.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import en.tedu.util.JDBCUtils;

/**
 * .这个类用来模拟用户登录过程
 */
public class LoginUser {
	//创建main方法,用来提示用户登录的信息
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//提示用户输入用户名
		System.out.println("请输入用户名:");
		String name = sc.nextLine();
		
		//提示用户输入密码
		System.out.println("请输入密码:");
		String pwd = sc.nextLine();
		
		//调用login方法,完成查询
		login(name,pwd);
		
	}
	//创建login方法,去数据库查询信息
	private static void login(String name, String pwd) {
		Connection conn = null;
		Statement st = 	null;
		ResultSet rs = 	null;
		
		//声明新对象,防止SQL攻击
		PreparedStatement ps = null;
		
		
		try {
			conn = JDBCUtils.getConnection();
//			st = conn.createStatement(); // 不安全
//			 根据用户名密码查询user表
//			String sql = "select * from user where username='"+name+"' and password='"+pwd+"'";
//			rs = st.executeQuery(sql); // 不安全			 
//			System.out.println(sql);
			
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			//设置参数
			ps.setString(1, name);
			ps.setString(2, pwd);
			//执行SQL
			rs = ps.executeQuery();
			System.out.println(ps);
			
			if(rs.next()) {
				System.out.println("恭喜你登录成功");
			}else {
				System.out.println("输入的用户名或者密码有误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}



























