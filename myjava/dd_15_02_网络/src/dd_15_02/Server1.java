package dd_15_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//在本机8000端口上启动服务
		//如果端口被占用,这里会出现异常
		ServerSocket ss = new ServerSocket(8001);
		System.out.println("服务已启动");
		
		//等待客户端发起连接请求,并建立连接通道
		Socket s = ss.accept();
		System.out.println("客户端已连接");
		
		//从Socket连接通道,获取流
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		/*
		 * 通信协议
		 * 通信流程丶数据格式
		 * 
		 * 1.接收5个字符 Hello
		 * 2.向对方发送5个字符 World
		 */
		
		for (int i = 0; i < 5; i++) {
			char c = (char) in.read();
			System.out.print(c);
		}
		
		out.write("Wrold".getBytes());
		out.flush();
		
		s.close();//断开连接
		ss.close();//停止服务释放端口
	}
}
