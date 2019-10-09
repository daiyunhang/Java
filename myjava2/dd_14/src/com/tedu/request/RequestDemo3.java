package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * .实现请求转发
 */
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestDemo3.doGet()");
		
		//将请求转发给RequestDemo4处理
		/*
		 *	 请求转发只能是同一个Web应用内部资源之间的跳转
		 *	不能是不同的Web应用或者不同的虚拟主机之间资源
		 *	的跳转!!
		 *	因此在转发时,转发的路径只需要写资源的路径,不需要
		 *	写主机名称和Web应用的虚拟路径
		 */
		request.getRequestDispatcher("/RequestDemo4").forward(request, response);;
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
