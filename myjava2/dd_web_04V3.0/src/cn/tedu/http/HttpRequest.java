package cn.tedu.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 这个类用来封装请求信息
 * 1.声明三个请求参数
 * 2.在构造函数中初始化请求参数
 * 3.改造run方法
 */
public class HttpRequest {
	//1.声明三个请求参数
	//GET /index.html HTTP/1.1
	private String method;//请求方式
	private String uri;//请求资源路径
	private String protocol;//协议名版本号
	
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
	
	
	//2.在构造函数中初始化请求参数
	public HttpRequest(InputStream in) {
		try {
			//获取请求流
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(in));
			
			//获取请求行
			String line = reader.readLine();
			if(line!=null&&line.length()>0) {
				String[] datas = line.split(" ");
				method = datas[0];
				uri = datas[1];
				//设置网站默认主页
				if(uri.equals("/")) {
					uri = "/index.html";
				}
				protocol = datas[2];
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//3.改造run方法
	
	
	
	
}
