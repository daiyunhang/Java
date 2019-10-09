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
					System.out.println("����������");
					while(true) {
						Socket s = ss.accept();
						//Socket����ͨ��,�����߳�
						//������ִ��ͨ���߳�
						TongXinThread t = new TongXinThread(s);
						t.start();
					}
				} catch (Exception e) {
					System.out.println("�˿ڱ�ռ��,���߷�����ֹͣ");
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
				 * ͨ��Э��
				 * 
				 * ����
				 * 1.����
				 * 2.����
				 * 
				 * ���ݸ�ʽ
				 * 1.GBK�����ַ� 
				 * 2.һ���ı�,ĩβҪ�л��з�
				 * 
				 * BR--ISR--������������
				 * PrintWriter--OSW--���������
				 * 
				 * println() �Լ��ӻ���
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
			System.out.println("�ͻ����ѶϿ�");
		}
	}
	
	public static void main(String[] args) {
		EchoServer server = new EchoServer();
		server.start();
	}
	
}
