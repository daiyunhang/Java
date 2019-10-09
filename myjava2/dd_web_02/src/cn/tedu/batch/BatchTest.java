package cn.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import en.tedu.util.JDBCUtils;

/**
 * 这个类用来完成jdbc的批处理
 */
public class BatchTest {
	
	//方式一
	@Test
	public void StatementTest() {
		Connection conn = null;
		Statement st = null;
		try {
		//1.注册驱动 2.获取数据库连接
		conn = JDBCUtils.getConnection();
		
		long start = System.currentTimeMillis();//计时
		//3.获取传输器
		st = conn.createStatement();
		
		//4.执行SQL
		for(int j = 0; j < 100; j++) {
			String sql = 
					"insert into dept values(null,'"+j+"')";
			//把SQL打成一个批次
			st.addBatch(sql);
			
		}
		//统一发送给服务器
		st.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, st, conn);
		}
	}
	
	//方式二
	@Test
	public void PSTest() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
		//1.注册驱动 2.获取数据库连接
		conn = JDBCUtils.getConnection();
		
		//a,,,,关闭jdbc的事务管理
		conn.setAutoCommit(false);
		
		long start = System.currentTimeMillis();//计时
		
		//3.获取传输器
		String sql = 
		"insert into dept values(null,?)";
		ps = conn.prepareStatement(sql);
		
		for (int i = 0; i < 1000; i++) {
			//设置参数
			ps.setString(1, "PS"+i);
			
			//把SQL打成批量
			ps.addBatch();
		}
		//统一把SQL发送给数据库服务器
		ps.executeBatch();
		
		//a,,,,手动提交事务管理
		conn.commit();
		
		long end = System.currentTimeMillis();//计时
		System.out.println(end-start);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, ps, conn);
		}
	}		
}
