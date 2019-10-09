package cn.tedu.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * ������������jdbc����ɾ�Ĳ� 
 */
public class JDBCCRUD {
	//��user���в���һ����¼
	@Test
	public void add() {
		Connection conn = null;
		Statement st = null;
		/*
		 * 1.ע������
		 * 2.��ȡ���ݿ�����
		 * 3.��ȡ������
		 * 4.ִ��SQL
		 * 5.���������
		 * 6.�ͷ���Դ 
		 */
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.��ȡ���ݿ�����
			String url="jdbc:mysql://localhost:3306/jt_db";
			String user="root";
			String password="Aa123456";
			conn = DriverManager.getConnection(url, user, password);

			//3.��ȡ������
			st = conn.createStatement();
			
			//4.ִ��SQL
			String sql = "insert into user values(null,'dyh','Aa123456')";
			int rows = st.executeUpdate(sql);
			
			//5.���������
			System.out.println(rows);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ,���ſ������Ź�
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
	
	//�޸�account����idΪ1�ļ�¼,moneyΪ200
	@Test
	public void update() {
		Connection conn = null;
		Statement st = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���ݿ�����
			String url="jdbc:mysql://localhost:3306/jt_db";
			String user="root";
			String password="Aa123456";
			conn = DriverManager.getConnection(url, user, password);
			//3.��ȡ������
			st = conn.createStatement();
			//4.ִ��SQL
			String sql = "update account set money=200 where id=1";
			int rows = st.executeUpdate(sql);
			//5.���������
			System.out.println(rows);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ,���ſ������Ź�
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

	//ɾ��user����idΪ4�ļ�¼
	@Test
	public void del() {
		Connection conn = null;
		Statement st = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���ݿ�����
			String url="jdbc:mysql:///jt_db";
			String user="root";
			String password="Aa123456";
			conn = DriverManager.getConnection(url, user, password);
			//3.��ȡ������
			st = conn.createStatement();
			//4.ִ��SQL
			String sql = "delete from user where id=4";
			int rows = st.executeUpdate(sql);
			//5.���������
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ,���ſ�,���Ź�
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
