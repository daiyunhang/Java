package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 请求重定向
 */
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResponseDemo2.doGet()");
		
		//将请求重定向到index.html(302+location)
		//response.sendRedirect("/dd_14/index.html");
		
		//重定向到别的web应用下的资源
//		response.sendRedirect("/dd_web_13/SecondServlet");
//		response.sendRedirect("https://www.taobao.com");
		//重定向到别的虚拟主机下的资源
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
