package cn.tedu.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * �����������װ������Ϣ
 * 1.���������������
 * 2.�ڹ��캯���г�ʼ���������
 * 3.����run����
 */
public class HttpRequest {
	//1.���������������
	//GET /index.html HTTP/1.1
	private String method;//����ʽ
	private String uri;//������Դ·��
	private String protocol;//Э�����汾��
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	
	//2.�ڹ��캯���г�ʼ���������
	public HttpRequest(InputStream in) {
		try {
			//��ȡ������
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(in));
			
			//��ȡ������
			String line = reader.readLine();
			if(line!=null&&line.length()>0) {
				String[] datas = line.split(" ");
				method = datas[0];
				uri = datas[1];
				//������վĬ����ҳ
				if(uri.equals("/")) {
					uri = "/index.html";
				}
				protocol = datas[2];
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//3.����run����
	
	
	
	
}
