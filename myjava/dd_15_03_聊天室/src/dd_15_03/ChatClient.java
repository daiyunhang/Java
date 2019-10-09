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
	//输入标记,没有输入是false-,
	//开始输入内容是true
	private boolean inputFlag = false;
	
	public void start(){
		try {
			s = new Socket("127.0.0.1" , 8000);
			in = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
			out = new PrintWriter(new OutputStreamWriter(s.getOutputStream() ,"GBK"));
			
			//输入昵称，发送到服务器
			System.out.println("昵称：");
			String name = new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();
			
			//等待输入聊天内容，并发送
			new Thread() {
				public void run() {
					input();
				};
			}.start();
			//打印线程
			new Thread() {
				public void run() {
					print();
				}
			};
			//等待接收聊天室内容
			new Thread() {
				public void run() {
					receive();
				};
			}.start();
		} catch (Exception e) {
			System.out.println("连接失败");
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
				//收到的聊天内容,加入到集合
				synchronized (list) {
					list.add(line);
					list.notifyAll();//通知等待的打印线程
				}
			}
		} catch (IOException e) {
		}
		System.out.println("连接已断开");
	}


	protected void input() {
		System.err.println("按回车开始输入");
		while(true){
			new Scanner(System.in).nextLine();
			inputFlag = true;//开始输入
			
			System.out.print("输入聊天内容");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();
			
			//输入完成改为false
			inputFlag = false;
			//通知打印线程
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
