package en.dutu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import en.detu.pool.MyPool;
import en.tedu.util.JDBCUtils;

/**
 * 这个类用来完成自定义连接池测试MyPool
 */
public class TestMyPool {
	
	@Test
	public void mytest() {
		//删除dept表中id为1的数据
//		MyPool pool = new MyPool();
		Connection conn = null;
		PreparedStatement ps = null;
		
		//c3p0连接池
		ComboPooledDataSource pool = new ComboPooledDataSource();
		
		try {
			//1.设置数据库连接的参数
//			pool.setDriverClass("");
//			pool.setJdbcUrl("");
//			pool.setUser("");
//			pool.setPassword("");
			
			
			
			//1.注册驱动 2.获取数据库连接
			conn = pool.getConnection();

			//3.获取传输器
			String sql = 
//			"delete from dept where id=?";
			"delete from dept where id between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "100005");
			ps.setString(2, "100010");
			
			//4.执行SQL
			int rows = ps.executeUpdate();
			
			//5.遍历结果集
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.释放资源
			/*JDBCUtils.close(null, ps, null);
			
			//conn还回池中
			pool.returnConnection(conn);*/
			
			JDBCUtils.close(null, ps, conn);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

