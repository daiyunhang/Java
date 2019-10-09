package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import cn.tedu.context.ServerContext;
import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

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
				HttpResponse response = 
						new HttpResponse(
							socket.getOutputStream());
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
