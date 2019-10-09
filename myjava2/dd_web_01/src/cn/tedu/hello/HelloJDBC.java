
package cn.tedu.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 1.�������������һ��jdbc��Ӧ��
 */
public class HelloJDBC {
	//��Ԫ���Է���hello
	//@Test + void
	/*
	 * 1.ע������
	 * 2.��ȡ���ݿ�����
	 * 3.��ȡ������
	 * 4.ִ��SQL
	 * 5.���������
	 * 6.�ͷ���Դ 
	 */
	@Test
	public void hello() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			//1.ע������ com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
			
			//2.��ȡ���ݿ�����
			//�������ݿ��url
			String url="jdbc:mysql://localhost:3306/jt_db";
			//�������ݿ���û���
			String user="root";
			//�������ݿ������
			String password="Aa123456";
			//java.sql.Connection
			conn = DriverManager.getConnection(url, user, password);
			
			//3.��ȡ������ java.sql.Statement
			st = conn.createStatement();
			
			//4.ִ��SQL����ѯaccount��
			String sql = "select * from account";
			rs = st.executeQuery(sql);
			
			//5.���������
			while(rs.next()) {
				//���������в�ѯ����
				String id = rs.getString(1);
				//ͨ���ֶ����ƻ�ȡ���ֶε�ֵ
				//String id2 = rs.getString("id");
				//���������в�ѯname��ֵ
				String name = rs.getString(2);
				//���������в�ѯmoney��ֵ
				String money = rs.getString(3);
				System.out.println(id+name+money);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ,���ſ������Ź�
			if(rs != null) {//��ֹ��ָ���쳣
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					rs = null;
				}
			}
			if(st != null) {//��ֹ��ָ���쳣
				try {
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					st = null;
				}
			}
			if(conn != null) {//��ֹ��ָ���쳣
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