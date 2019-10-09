package cn.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import en.tedu.util.JDBCUtils;

/**
 * .���������ģ���û���¼����
 */
public class LoginUser {
	//����main����,������ʾ�û���¼����Ϣ
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//��ʾ�û������û���
		System.out.println("�������û���:");
		String name = sc.nextLine();
		
		//��ʾ�û���������
		System.out.println("����������:");
		String pwd = sc.nextLine();
		
		//����login����,��ɲ�ѯ
		login(name,pwd);
		
	}
	//����login����,ȥ���ݿ��ѯ��Ϣ
	private static void login(String name, String pwd) {
		Connection conn = null;
		Statement st = 	null;
		ResultSet rs = 	null;
		
		//�����¶���,��ֹSQL����
		PreparedStatement ps = null;
		
		
		try {
			conn = JDBCUtils.getConnection();
//			st = conn.createStatement(); // ����ȫ
//			 �����û��������ѯuser��
//			String sql = "select * from user where username='"+name+"' and password='"+pwd+"'";
//			rs = st.executeQuery(sql); // ����ȫ			 
//			System.out.println(sql);
			
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			//���ò���
			ps.setString(1, name);
			ps.setString(2, pwd);
			//ִ��SQL
			rs = ps.executeQuery();
			System.out.println(ps);
			
			if(rs.next()) {
				System.out.println("��ϲ���¼�ɹ�");
			}else {
				System.out.println("������û���������������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}



























