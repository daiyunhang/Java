package en.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 这个类用来完成jdbc工具类的开发
 */
public class JDBCUtils {
	//6.2.1 私有化构造函数,防止外界直接创建对象
	private JDBCUtils() {};
	
	//6.2.2 提供静态方法 getConnection 用来对外提供数据库连接对象
	public static Connection getConnection(){
		try {
			//读取属性文件的数据 src/jdbc.properties
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			
			//1.注册驱动
			Class.forName(rb.getString("driverClass"));
			//2.获取数据库连接
			String url=rb.getString("jdbcUrl");
			String user=rb.getString("user");
			String password=rb.getString("password");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	//6.2.3 提供静态方法 close 用来释放资源
	public static void close(ResultSet rs,Statement st, Connection conn) {
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
