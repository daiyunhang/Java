package cn.tedu.http;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 这个类用来封装响应信息
 * 1.声明4个响应参数,set get方法
 * 2.在构造函数中传入 OutputStream 对象
 * 3.改造getOutputStream 方法,并给参数赋值
 * 4.改造run方法
 */
public class HttpResponse {
	
	//1.声明4个响应参数,set get方法
	/*
	 * HTTP/1.1 200 OK
	 * Content-Type:text/html
	 * Content-Length:294
	 */
	private String protocol;//协议名和版本号
	private int status;//状态码
	private String contentType;//响应类型
	private int contentLength;//响应长度
	
	//2.在构造函数中传入 OutputStream 对象
	private OutputStream out;
	public HttpResponse(OutputStream out) {
		this.out = out;
	}
	
	//3.改造getOutputStream 方法,并给参数赋值
	//保证响应头只被发送一次
	boolean isSend;//默认是false
	public OutputStream getOut() {
		if(!isSend) {
			//拼接响应头的过程
			PrintStream ps = new PrintStream(out);
			
			//拼接状态行
			ps.println(protocol+" "+status+" OK");
			//响应类型
			ps.println("Content-Type:"+contentType);
			//响应长度
			ps.println("Content-Length:"+contentLength);
			//空白行
			ps.println();
			
			isSend = true;//改变发送状态
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
