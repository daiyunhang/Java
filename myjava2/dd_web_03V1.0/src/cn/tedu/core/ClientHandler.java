package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *    ������������WebServer����Ż�,��ȡ����
 * 1.�����߳���
 * 2.��������ͻ��˵�Socket����
 * 3.�������캯��,����Socket���󲢱���������
 */
//1.�����߳���
public class ClientHandler implements Runnable{

//2.��������ͻ��˵�Socket����
	private Socket socket;
	
//3.�������캯��,����Socket���󲢱���������
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
//4.��дrun����
	@Override
	public void run() {
		//a ����PrintStream����
		try {
			BufferedReader reader = 
					new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
			
			//��ȡ������
			//str -> GET /index.html HPPS/1.1
			String str = reader.readLine();
			
			//��ȡ���ʵ���Դ·��
			//���ո��и��ַ��� strs->[GET,/index.html,HTTP/1.1]
			String[] strs = str.split(" ");
			
			//uri->/index.html
			String uri = strs[1];
			
			//����Ĭ����վ
			if(uri.equals("/")) {
				uri="/index.html";
			} 
			
			
			
			
			PrintStream ps = new PrintStream(socket.getOutputStream());
		//b ƴ����Ӧͷ
			//״̬��
			ps.println("HTTP/1.1 200 OK");
			ps.println("Content-type:text/html");
//			String data = "hello world!";
//			String data = "��ŵ��ID����Ƭ��ŭ��żٿ�҅���������举Ů���Ͽ�";
//			ps.println("Content-Length:"+data.length());
//			ps.println("Content-Length:"+data.getBytes().length);
			
			//������������ҳ�ļ�
//			File file = new File("WebContent/index.html");//��ȡָ��λ�õ��ļ�
			File file = new File("WebContent"+uri);//��ȡָ��λ�õ��ļ�
			ps.println("Content-Length:"+file.length());
			
			ps.println();
//			ps.write(data.getBytes());
			
			//��Ӧһ����ҳ�ļ�
			BufferedInputStream bis = 
					new BufferedInputStream(
							new FileInputStream(file));
			byte[] bs = new byte[(int) file.length()];
			bis.read(bs);
			
			//��Ӧ
			ps.write(bs);
//			System.out.println("---------");
			ps.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
