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
 *    这个类用来完成WebServer类的优化,提取代码
 * 1.创建线程类
 * 2.创建代表客户端的Socket对象
 * 3.创建构造函数,传入Socket对象并保存在类中
 */
//1.创建线程类
public class ClientHandler implements Runnable{

//2.创建代表客户端的Socket对象
	private Socket socket;
	
//3.创建构造函数,传入Socket对象并保存在类中
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
//4.重写run方法
	@Override
	public void run() {
		//a 创建PrintStream对象
		try {
			
			//利用请求对象完成请求过程
			HttpRequest request = new HttpRequest(socket.getInputStream());
			
			
			//防止request.getUri() = null
			if(request.getUri()!=null && request.getUri().length()>0) {
		
				//利用响应对象完成响应过程
				HttpResponse response = new HttpResponse(socket.getOutputStream());
				
				//判断用户是否要完成登录或者注册的功能
				if(request.getUri().startsWith("/LoginUser")
						||request.getUri().startsWith("/RegistUser")) {
					
					//利用service方法完成登录或者注册过程
					service(request,response);
					return;
				}
				
				
				//设置参数
				response.setProtocol(ServerContext.protocol);
				//向浏览器输出网页文件
				File file = new File(ServerContext.webRoot+"/"+request.getUri());//读取指定位置的文件
				response.setContentType(getContentTypeByFile(file));
				
				//判断访问的文件是否存在
				if(!file.exists()) {
					//跳转到ServerContext404.html
					file = new File(ServerContext.webRoot+"/"+ServerContext.notFoundPage);
					//设置404状态码
					response.setStatus(404);
				}else {
					response.setStatus(200);
				}
				
				response.setContentLength((int)file.length());
				
				//响应一个网页文件
				BufferedInputStream bis = 
						new BufferedInputStream(
								new FileInputStream(file));
				byte[] bs = new byte[(int) file.length()];
				bis.read(bs);
				//响应
				response.getOut().write(bs);
				response.getOut().flush();
				socket.close();
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//完成注册或登录,操作数据库的过程
	private void service(HttpRequest request, HttpResponse response) {
		//完成注册,用jdbc向数据库表插入记录
		if(request.getUri().startsWith("/RegistUser")) {
			Connection conn = null;
			PreparedStatement ps = null;
			
			try {
				conn = JDBCUtils.getConnection();
				String sql = "insert into user values(null,?,?)";
				ps = conn.prepareStatement(sql);
				
				//设置参数
				String name = request.getParameter("username");
				String pwd = request.getParameter("password");
				ps.setString(1, name);
				ps.setString(2, pwd);
				
				int rows = ps.executeUpdate();
				System.out.println(rows);
				
				//给浏览器响应注册成功页面
				response.setProtocol(ServerContext.protocol);//响应的协议和版本号
				response.setStatus(HttpContext.CODE_OK);
				
				//响应注册成功文件
				File file = new File(
						ServerContext.webRoot+"/regist_success.html");
				
				response.setContentType(getContentTypeByFile(file));
				response.setContentLength((int)file.length());//响应长度
				
				//读文件写文件
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

	//根据访问文件的后缀名作为key,去map中找value
	private String getContentTypeByFile(File file) {
		
		//获取文件名
		String fileName = file.getName();
		//根据文件名获取文件的后缀名
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		//拿到后缀名,去map中找value
		String val = ServerContext.typeMap.get(ext);
		return val;
	}
	
}
