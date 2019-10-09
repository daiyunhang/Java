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
				System.out.println("����(exit�˳�): ");
				String str = new Scanner(System.in).nextLine();
				if("exit".equals(str)) {
					s.close();//�Ͽ�����
					break;
				}
				//��str���͵�������
				out.println(str);
				out.flush();
				
				//���ջ�������
				String echo = in.readLine();
				System.out.println("����:"+ echo);
			}
		} catch (Exception e) {
		}
		System.out.println("�Ѿ���������Ͽ�����");
	}
	public static void main(String[] args) {
		EchoClient clint = new EchoClient();
		clint.start();
	}
}
