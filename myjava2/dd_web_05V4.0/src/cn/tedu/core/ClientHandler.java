package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.tedu.context.HttpContext;
import cn.tedu.context.ServerContext;
import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;
import en.tedu.util.JDBCUtils;

/**
 *    ������������WebServer����Ż�,��ȡ����
 * 1.�����߳���
 * 2.��������ͻ��˵�Socket����
 * 3.�������캯��,����Socket���󲢱���������
 */
//1.�����߳���
public class ClientHandler implements Runnable{

//2.��������ͻ��˵�Socket����
	private Socket socket;
	
//3.�������캯��,����Socket���󲢱���������
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
//4.��дrun����
	@Override
	public void run() {
		//a ����PrintStream����
		try {
			
			//���������������������
			HttpRequest request = new HttpRequest(socket.getInputStream());
			
			
			//��ֹrequest.getUri() = null
			if(request.getUri()!=null && request.getUri().length()>0) {
		
				//������Ӧ���������Ӧ����
				HttpResponse response = new HttpResponse(socket.getOutputStream());
				
				//�ж��û��Ƿ�Ҫ��ɵ�¼����ע��Ĺ���
				if(request.getUri().startsWith("/LoginUser")
						||request.getUri().startsWith("/RegistUser")) {
					
					//����service������ɵ�¼����ע�����
					service(request,response);
					return;
				}
				
				
				//���ò���
				response.setProtocol(ServerContext.protocol);
				//������������ҳ�ļ�
				File file = new File(ServerContext.webRoot+"/"+request.getUri());//��ȡָ��λ�õ��ļ�
				response.setContentType(getContentTypeByFile(file));
				
				//�жϷ��ʵ��ļ��Ƿ����
				if(!file.exists()) {
					//��ת��ServerContext404.html
					file = new File(ServerContext.webRoot+"/"+ServerContext.notFoundPage);
					//����404״̬��
					response.setStatus(404);
				}else {
					response.setStatus(200);
				}
				
				response.setContentLength((int)file.length());
				
				//��Ӧһ����ҳ�ļ�
				BufferedInputStream bis = 
						new BufferedInputStream(
								new FileInputStream(file));
				byte[] bs = new byte[(int) file.length()];
				bis.read(bs);
				//��Ӧ
				response.getOut().write(bs);
				response.getOut().flush();
				socket.close();
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//���ע����¼,�������ݿ�Ĺ���
	private void service(HttpRequest request, HttpResponse response) {
		//���ע��,��jdbc�����ݿ������¼
		if(request.getUri().startsWith("/RegistUser")) {
			Connection conn = null;
			PreparedStatement ps = null;
			
			try {
				conn = JDBCUtils.getConnection();
				String sql = "insert into user values(null,?,?)";
				ps = conn.prepareStatement(sql);
				
				//���ò���
				String name = request.getParameter("username");
				String pwd = request.getParameter("password");
				ps.setString(1, name);
				ps.setString(2, pwd);
				
				int rows = ps.executeUpdate();
				System.out.println(rows);
				
				//���������Ӧע��ɹ�ҳ��
				response.setProtocol(ServerContext.protocol);//��Ӧ��Э��Ͱ汾��
				response.setStatus(HttpContext.CODE_OK);
				
				//��Ӧע��ɹ��ļ�
				File file = new File(
						ServerContext.webRoot+"/regist_success.html");
				
				response.setContentType(getContentTypeByFile(file));
				response.setContentLength((int)file.length());//��Ӧ����
				
				//���ļ�д�ļ�
				BufferedInputStream bis = 
						new BufferedInputStream(
								new FileInputStream(file));
				byte[] b = new byte[(int)file.length()];
				bis.read(b);
				response.getOut().write(b);
				response.getOut().flush();
				socket.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JDBCUtils.close(null, ps, conn);
			}
		}
		
	}

	//���ݷ����ļ��ĺ�׺����Ϊkey,ȥmap����value
	private String getContentTypeByFile(File file) {
		
		//��ȡ�ļ���
		String fileName = file.getName();
		//�����ļ�����ȡ�ļ��ĺ�׺��
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		//�õ���׺��,ȥmap����value
		String val = ServerContext.typeMap.get(ext);
		return val;
	}
	
}
