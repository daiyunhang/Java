package dd_15_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//�ڱ���8000�˿�����������
		//����˿ڱ�ռ��,���������쳣
		ServerSocket ss = new ServerSocket(8001);
		System.out.println("����������");
		
		//�ȴ��ͻ��˷�����������,����������ͨ��
		Socket s = ss.accept();
		System.out.println("�ͻ���������");
		
		//��Socket����ͨ��,��ȡ��
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		/*
		 * ͨ��Э��
		 * ͨ������ؼ���ݸ�ʽ
		 * 
		 * 1.����5���ַ� Hello
		 * 2.��Է�����5���ַ� World
		 */
		
		for (int i = 0; i < 5; i++) {
			char c = (char) in.read();
			System.out.print(c);
		}
		
		out.write("Wrold".getBytes());
		out.flush();
		
		s.close();//�Ͽ�����
		ss.close();//ֹͣ�����ͷŶ˿�
	}
}
