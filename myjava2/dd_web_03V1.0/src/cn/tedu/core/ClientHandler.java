package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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
			BufferedReader reader = 
					new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
			
			//读取请求行
			//str -> GET /index.html HPPS/1.1
			String str = reader.readLine();
			
			//获取访问的资源路径
			//按空格切割字符串 strs->[GET,/index.html,HTTP/1.1]
			String[] strs = str.split(" ");
			
			//uri->/index.html
			String uri = strs[1];
			
			//设置默认网站
			if(uri.equals("/")) {
				uri="/index.html";
			} 
			
			
			
			
			PrintStream ps = new PrintStream(socket.getOutputStream());
		//b 拼接响应头
			//状态行
			ps.println("HTTP/1.1 200 OK");
			ps.println("Content-type:text/html");
//			String data = "hello world!";
//			String data = "赛诺菲ID是那片愤怒你放假看覅静安寺配电间妇女节上课";
//			ps.println("Content-Length:"+data.length());
//			ps.println("Content-Length:"+data.getBytes().length);
			
			//向浏览器输出网页文件
//			File file = new File("WebContent/index.html");//读取指定位置的文件
			File file = new File("WebContent"+uri);//读取指定位置的文件
			ps.println("Content-Length:"+file.length());
			
			ps.println();
//			ps.write(data.getBytes());
			
			//响应一个网页文件
			BufferedInputStream bis = 
					new BufferedInputStream(
							new FileInputStream(file));
			byte[] bs = new byte[(int) file.length()];
			bis.read(bs);
			
			//响应
			ps.write(bs);
//			System.out.println("---------");
			ps.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
