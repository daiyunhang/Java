package dd_15_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//本机回环ip  localhost  127.0.0.1
		 Socket s = new Socket("192.168.10.149",8001);
		 
		 InputStream in = s.getInputStream();
		 OutputStream out = s.getOutputStream();
		 
		/*
		 * 通信协议
		 * 通信流程丶数据格式
		 * 
		 * 1.法送5个字符 Hello
		 * 2.接收5个字符 World
		 */
		 
		 out.write("Hello".getBytes());
		 out.flush();
		 
		 for (int i = 0; i < 5; i++) {
			char c = (char) in.read();
			System.out.println(c);
		}
		 
		 s.close();
		 
		 
		 
	}
}
