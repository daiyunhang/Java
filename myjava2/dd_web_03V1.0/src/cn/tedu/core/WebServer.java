package cn.tedu.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 0.这个类用来代表服务器端程序
 * 1.生命ServerSocket,代表服务器端
 * 2.在构造函数中初始化ServerSocket对象
 * 3.创建start方法,用来接收请求,处理业务,
 * 4.创建main方法,启动服务器
 */
public class WebServer {
	
	//1.生命ServerSocket,代表服务器端
	private ServerSocket server;
		
		//a.声明线程池对象
		private ExecutorService pool;
	
	//2.在构造函数中初始化ServerSocket对象
	public WebServer() {
		try {
			server = new ServerSocket(8083);
			
			//b.在构造函数中初始化线程池
			pool = Executors.newFixedThreadPool(100);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 
	//3.创建start方法,用来接收请求,处理业务,
	public void start() {
		//用来接收请求;
		try {
			while(true) {
			//1.声明ServerSocket 代表服务
			Socket socket = server.accept();
			
/*			//输出响应信息
			//---不符合http响应协议 
//			OutputStream out = socket.getOutputStream();
//			out.write("hello server~".getBytes());
//			System.out.println("123456789");
//			out.flush();
			
				//状态行 Contenet-Length  Contenet-Type
				//空白行 响应实体内容
				PrintStream ps = new PrintStream(socket.getOutputStream());
				ps.println("HTTP/1.1 200 OK");//状态行
				ps.println("Content-Type:text/html"); //Content-Type响应头
				String data = "hello server~";
				ps.println("Content-Length:"+data.length());//Content-Length响应头
				ps.println();//空白行
				ps.write(data.getBytes());//响应实体内容
				System.out.println("1561516556");
				ps.flush();
				socket.close();*/

			//c.改造start方法				
			pool.execute(new ClientHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//4.创建main方法,启动服务器
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}























