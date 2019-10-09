package cn.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import en.tedu.util.JDBCUtils;

/**
 * ������������jdbc��������
 */
public class BatchTest {
	
	//��ʽһ
	@Test
	public void StatementTest() {
		Connection conn = null;
		Statement st = null;
		try {
		//1.ע������ 2.��ȡ���ݿ�����
		conn = JDBCUtils.getConnection();
		
		long start = System.currentTimeMillis();//��ʱ
		//3.��ȡ������
		st = conn.createStatement();
		
		//4.ִ��SQL
		for(int j = 0; j < 100; j++) {
			String sql = 
					"insert into dept values(null,'"+j+"')";
			//��SQL���һ������
			st.addBatch(sql);
			
		}
		//ͳһ���͸�������
		st.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, st, conn);
		}
	}
	
	//��ʽ��
	@Test
	public void PSTest() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
		//1.ע������ 2.��ȡ���ݿ�����
		conn = JDBCUtils.getConnection();
		
		//a,,,,�ر�jdbc���������
		conn.setAutoCommit(false);
		
		long start = System.currentTimeMillis();//��ʱ
		
		//3.��ȡ������
		String sql = 
		"insert into dept values(null,?)";
		ps = conn.prepareStatement(sql);
		
		for (int i = 0; i < 1000; i++) {
			//���ò���
			ps.setString(1, "PS"+i);
			
			//��SQL�������
			ps.addBatch();
		}
		//ͳһ��SQL���͸����ݿ������
		ps.executeBatch();
		
		//a,,,,�ֶ��ύ�������
		conn.commit();
		
		long end = System.currentTimeMillis();//��ʱ
		System.out.println(end-start);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, ps, conn);
		}
	}		
}
