package dd_15_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private List<TongXinThread> list = new ArrayList<>();
	
	
	public void start(){
		new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(8000);
					System.err.println("����������");
					while(true){
					 	Socket s = ss.accept();
					 	TongXinThread t = new TongXinThread(s);
					 	synchronized (list) {
					 		list.add(t);
						}
					 	t.start();
					}
				} catch (Exception e) {
					System.out.println("�˿ڱ�ռ�ã�������������ֹͣ");
				}
			}
		}.start();
	}
	
	class TongXinThread extends Thread {
		Socket s;
		BufferedReader in;
		PrintWriter out;
		String name;
		public TongXinThread(Socket s) {
			this.s = s;
		}
		
		//��ǰ�ͻ��˷���
		public void send(String msg) {
			out.println(msg);
			out.flush();
		}
		
		//�����пͻ��˷���
		public void sendAll(String msg) {
			//����ͨ���̶߳��󣬵���send����
			for (TongXinThread t : list) {
				t.send(msg);
			}
		}
		
		@Override
		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
				out = new PrintWriter(new OutputStreamWriter(s.getOutputStream() ,"GBK"));
				
				//���տͻ����ǳ�
				name = in.readLine();
				//Ⱥ����Ϣxxx����������
				synchronized (list) {
					sendAll(name+"������������,��������:"+list.size());
				}
				//ѭ�������������ݣ���Ⱥ��
				String line;
				while((line = in.readLine()) != null) {
					synchronized (list) {
						sendAll(name +"˵��"+ line);
					}
				}
				
			} catch (Exception e) {
			}
			//��ǰ�ͻ������ӶϿ�
			//��ǰͨ���̶߳��󣬴Ӽ����Ƴ�
			synchronized (list) {
				list.remove(this);
				//Ⱥ����Ϣ��xxx�뿪
				sendAll(name+"�뿪�������ң�����������"+list.size());
			}
			
		}
	}
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
	}
	
	
	
	
	
	
	
	
}
