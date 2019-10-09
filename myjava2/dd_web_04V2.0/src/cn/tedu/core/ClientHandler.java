package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

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
			
			//���������������������
			HttpRequest request = new HttpRequest(socket.getInputStream());
			
			//������Ӧ���������Ӧ����
			HttpResponse response = 
					new HttpResponse(
						socket.getOutputStream());
			//���ò���
			response.setProtocol("HTTP/1.1");
			response.setStatus(200);
			response.setContentType("text/html");
			//������������ҳ�ļ�
			File file = new File("WebContent/"+request.getUri());//��ȡָ��λ�õ��ļ�
			response.setContentLength((int)file.length());
			
			//��Ӧһ����ҳ�ļ�
			BufferedInputStream bis = 
					new BufferedInputStream(
							new FileInputStream(file));
			byte[] bs = new byte[(int) file.length()];
			bis.read(bs);
			
			//��Ӧ
			response.getOut().write(bs);
			response.getOut().flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
