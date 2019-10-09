package en.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * ������������jdbc������Ŀ���
 */
public class JDBCUtils {
	//6.2.1 ˽�л����캯��,��ֹ���ֱ�Ӵ�������
	private JDBCUtils() {};
	
	//6.2.2 �ṩ��̬���� getConnection ���������ṩ���ݿ����Ӷ���
	public static Connection getConnection(){
		try {
			//��ȡ�����ļ������� src/jdbc.properties
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			
			//1.ע������
			Class.forName(rb.getString("driverClass"));
			//2.��ȡ���ݿ�����
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
	
	
	//6.2.3 �ṩ��̬���� close �����ͷ���Դ
	public static void close(ResultSet rs,Statement st, Connection conn) {
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
