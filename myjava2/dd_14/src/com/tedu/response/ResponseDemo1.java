package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  .向客户端发送数据
 */
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//防止乱码
//		1.getOutputStream
		/*
		ServletOutputStream out = response.getOutputStream();
		out.write("hello".getBytes("utf-8"));
		out.write("哈喽!".getBytes("utf-8"));
		System.out.println("加载了");
		*/
		
//		2.getWriter
		/*
		 * 1.这行代码会通知服务器使用utf-8来发送数据
		 * 2.还会通知浏览器使用tuf-8来接收数据
		 */
		response.setContentType("text/html;charset=utf-8");//防止乱码
		response.getWriter().write("哈喽");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
