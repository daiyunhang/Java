package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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
			
			//利用响应对象完成响应过程
			HttpResponse response = 
					new HttpResponse(
						socket.getOutputStream());
			//设置参数
			response.setProtocol("HTTP/1.1");
			response.setStatus(200);
			response.setContentType("text/html");
			//向浏览器输出网页文件
			File file = new File("WebContent/"+request.getUri());//读取指定位置的文件
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
