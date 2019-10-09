package dd_15_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public void start() {
		try {
			Socket s = new Socket("192.168.10.149" , 8001);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream() ,"GBK"));
			
			while(true) {
				System.out.println("输入(exit退出): ");
				String str = new Scanner(System.in).nextLine();
				if("exit".equals(str)) {
					s.close();//断开连接
					break;
				}
				//把str法送到服务器
				out.println(str);
				out.flush();
				
				//接收回声数据
				String echo = in.readLine();
				System.out.println("回声:"+ echo);
			}
		} catch (Exception e) {
		}
		System.out.println("已经与服务器断开连接");
	}
	public static void main(String[] args) {
		EchoClient clint = new EchoClient();
		clint.start();
	}
}
