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
			server = new ServerSocket(8083);
			
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
			
/*			//�����Ӧ��Ϣ
			//---������http��ӦЭ�� 
//			OutputStream out = socket.getOutputStream();
//			out.write("hello server~".getBytes());
//			System.out.println("123456789");
//			out.flush();
			
				//״̬�� Contenet-Length  Contenet-Type
				//�հ��� ��Ӧʵ������
				PrintStream ps = new PrintStream(socket.getOutputStream());
				ps.println("HTTP/1.1 200 OK");//״̬��
				ps.println("Content-Type:text/html"); //Content-Type��Ӧͷ
				String data = "hello server~";
				ps.println("Content-Length:"+data.length());//Content-Length��Ӧͷ
				ps.println();//�հ���
				ps.write(data.getBytes());//��Ӧʵ������
				System.out.println("1561516556");
				ps.flush();
				socket.close();*/

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























