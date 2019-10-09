package en.dutu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import en.detu.pool.MyPool;
import en.tedu.util.JDBCUtils;

/**
 * �������������Զ������ӳز���MyPool
 */
public class TestMyPool {
	
	@Test
	public void mytest() {
		//ɾ��dept����idΪ1������
//		MyPool pool = new MyPool();
		Connection conn = null;
		PreparedStatement ps = null;
		
		//c3p0���ӳ�
		ComboPooledDataSource pool = new ComboPooledDataSource();
		
		try {
			//1.�������ݿ����ӵĲ���
//			pool.setDriverClass("");
//			pool.setJdbcUrl("");
//			pool.setUser("");
//			pool.setPassword("");
			
			
			
			//1.ע������ 2.��ȡ���ݿ�����
			conn = pool.getConnection();

			//3.��ȡ������
			String sql = 
//			"delete from dept where id=?";
			"delete from dept where id between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "100005");
			ps.setString(2, "100010");
			
			//4.ִ��SQL
			int rows = ps.executeUpdate();
			
			//5.���������
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ
			/*JDBCUtils.close(null, ps, null);
			
			//conn���س���
			pool.returnConnection(conn);*/
			
			JDBCUtils.close(null, ps, conn);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

