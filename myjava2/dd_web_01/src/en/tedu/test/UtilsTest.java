package en.tedu.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import en.tedu.util.JDBCUtils;

/**
 *	�������������jbc������
 */
public class UtilsTest {
	//��ѯuser�����������
	@Test
	public void utils() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from user";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String money = rs.getString(3);
				System.out.println(id+name+money);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(rs, st, conn);
		}
		
	}
}
