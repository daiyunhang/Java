package cn.tedu.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 0.�������������������˳���
 * 1.����ServerSocket,�����������
 * 2.�ڹ��캯���г�ʼ��ServerSocket����
 * 3.����start����,������������,����ҵ��,
 * 4.����main����,����������
 */
public class WebServer {
	
	//1.����ServerSocket,�����������
	private ServerSocket server;
		
		//a.�����̳߳ض���
		private ExecutorService pool;
	
	//2.�ڹ��캯���г�ʼ��ServerSocket����
	public WebServer() {
		try {
			server = new ServerSocket(8088);
			
			//b.�ڹ��캯���г�ʼ���̳߳�
			pool = Executors.newFixedThreadPool(100);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 
	//3.����start����,������������,����ҵ��,
	public void start() {
		//������������;
		try {
			while(true) {
			//1.����ServerSocket �������
			Socket socket = server.accept();

			//c.����start����				
			pool.execute(new ClientHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//4.����main����,����������
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}























