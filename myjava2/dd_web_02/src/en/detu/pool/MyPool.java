package en.detu.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import en.tedu.util.JDBCUtils;

/**
 * ����������Զ������ӳ�
 * 1.����MyPool��,ʵ��DataSoure�ӿ�
 * 2.��������,����������ݿ����Ӷ���
 * 3.��ʼ������
 * 4.�ṩgetConnection(),�����ṩ���ݿ�����
 * 5.�ṩreturnConnection(),���س���
 */
public class MyPool implements DataSource {
	
	//2.��������,����������ݿ����Ӷ���
	static List<Connection> list = new LinkedList<Connection>();
	
	//3.��ʼ������
	static {
		for (int i = 0; i < 3; i++) {
			Connection conn = JDBCUtils.getConnection();
			//�����ӷ������
			list.add(conn);
		}
	}
	
	//4.�ṩgetConnection(),�����ṩ���ݿ�����
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = list.remove(0);
		System.out.println("���ӱ�����1��,��ʣ:"+list.size());
		return conn;
	}
	
	//5.�ṩreturnConnection(),���س���
	public void returnConnection(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				list.add(conn);
				System.out.println("���ӱ�����,����"+list.size()+"��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
