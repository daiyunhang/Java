package cn.tedu.http;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * �����������װ��Ӧ��Ϣ
 * 1.����4����Ӧ����,set get����
 * 2.�ڹ��캯���д��� OutputStream ����
 * 3.����getOutputStream ����,����������ֵ
 * 4.����run����
 */
public class HttpResponse {
	
	//1.����4����Ӧ����,set get����
	/*
	 * HTTP/1.1 200 OK
	 * Content-Type:text/html
	 * Content-Length:294
	 */
	private String protocol;//Э�����Ͱ汾��
	private int status;//״̬��
	private String contentType;//��Ӧ����
	private int contentLength;//��Ӧ����
	
	//2.�ڹ��캯���д��� OutputStream ����
	private OutputStream out;
	public HttpResponse(OutputStream out) {
		this.out = out;
	}
	
	//3.����getOutputStream ����,����������ֵ
	//��֤��Ӧͷֻ������һ��
	boolean isSend;//Ĭ����false
	public OutputStream getOut() {
		if(!isSend) {
			//ƴ����Ӧͷ�Ĺ���
			PrintStream ps = new PrintStream(out);
			
			//ƴ��״̬��
			ps.println(protocol+" "+status+" OK");
			//��Ӧ����
			ps.println("Content-Type:"+contentType);
			//��Ӧ����
			ps.println("Content-Length:"+contentLength);
			//�հ���
			ps.println();
			
			isSend = true;//�ı䷢��״̬
		}
		return out;
	}
	
	public void setOut(OutputStream out) {
		this.out = out;
	}
	
	
	
	
	//getter & setter
	public String getProtocol() {
		return protocol;
	}
	


	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
