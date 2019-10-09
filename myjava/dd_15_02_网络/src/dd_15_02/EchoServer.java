package dd_15_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public void start() {
		new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(8001);
					System.out.println("服务已启动");
					while(true) {
						Socket s = ss.accept();
						//Socket连接通道,交给线程
						//来并行执行通信线程
						TongXinThread t = new TongXinThread(s);
						t.start();
					}
				} catch (Exception e) {
					System.out.println("端口被占用,或者服务已停止");
				}
			}
		}.start();
	}
	
	class TongXinThread extends Thread {
		Socket s;

		public TongXinThread(Socket s) {
			this.s = s;
		}
		@Override
		public void run() {
			try {
				/*
				 * 通信协议
				 * 
				 * 流程
				 * 1.接收
				 * 2.法送
				 * 
				 * 数据格式
				 * 1.GBK编码字符 
				 * 2.一行文本,末尾要有换行符
				 * 
				 * BR--ISR--网络流输入流
				 * PrintWriter--OSW--网络输出流
				 * 
				 * println() 自己加换行
				 */
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream() ,"GBK"));
				
				String line;
				while((line = in.readLine()) != null) {
					out.println(line);
					out.flush();
					System.out.println(line);
				}
			} catch (Exception e) {
			}
			System.out.println("客户端已断开");
		}
	}
	
	public static void main(String[] args) {
		EchoServer server = new EchoServer();
		server.start();
	}
	
}
