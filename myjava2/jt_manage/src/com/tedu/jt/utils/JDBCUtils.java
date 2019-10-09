package com.tedu.jt.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * JDBC工具类
 */
public class JDBCUtils {
	/**
	 * 2.创建c3p0连接池实例
	 */
	private static ComboPooledDataSource pool 
					= new ComboPooledDataSource();

	/**
	 * 1.私有化构造函数
	 */
	private JDBCUtils() {}

	/**
	 * 3.
	 * @return Connection 
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception {
		try {
			return pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 4.
	 * @param conn 
	 * @param ps 
	 * @param rs 
	 */
	public static void close(Connection conn, Statement stat,
			ResultSet rs) {
		if(rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat != null ){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn != null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
}
