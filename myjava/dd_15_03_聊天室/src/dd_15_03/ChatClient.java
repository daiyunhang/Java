package dd_15_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ChatClient {
	private Socket s;
	private BufferedReader in;
	private PrintWriter out;
	private LinkedList<String> list = new LinkedList<>();
	//������,û��������false-,
	//��ʼ����������true
	private boolean inputFlag = false;
	
	public void start(){
		try {
			s = new Socket("127.0.0.1" , 8000);
			in = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
			out = new PrintWriter(new OutputStreamWriter(s.getOutputStream() ,"GBK"));
			
			//�����ǳƣ����͵�������
			System.out.println("�ǳƣ�");
			String name = new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();
			
			//�ȴ������������ݣ�������
			new Thread() {
				public void run() {
					input();
				};
			}.start();
			//��ӡ�߳�
			new Thread() {
				public void run() {
					print();
				}
			};
			//�ȴ���������������
			new Thread() {
				public void run() {
					receive();
				};
			}.start();
		} catch (Exception e) {
			System.out.println("����ʧ��");
		}
	}


	protected void print() {
		while(true) {
			synchronized (list) {
				while(inputFlag || list.size() == 0) {
					try {
						list.wait();
					} catch (Exception e) {

					}
					
				}
				System.out.println(list.removeFirst());
			}
		}
	}


	protected void receive() {
		String line;
		try {
			while((line = in.readLine()) != null ) {
				//�յ�����������,���뵽����
				synchronized (list) {
					list.add(line);
					list.notifyAll();//֪ͨ�ȴ��Ĵ�ӡ�߳�
				}
			}
		} catch (IOException e) {
		}
		System.out.println("�����ѶϿ�");
	}


	protected void input() {
		System.err.println("���س���ʼ����");
		while(true){
			new Scanner(System.in).nextLine();
			inputFlag = true;//��ʼ����
			
			System.out.print("������������");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();
			
			//������ɸ�Ϊfalse
			inputFlag = false;
			//֪ͨ��ӡ�߳�
			synchronized (list) {
				list.notify();
			}
		}
	}
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.start();
	}
}
