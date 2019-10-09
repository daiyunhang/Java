package com.tedu.request;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
		//获取用户名
		String username = request.getParameter("username");
		System.out.println("username="+username);
		
		//获取爱好
		String[] likes = request.getParameterValues("like");
		System.out.println("likes:"+Arrays.toString(likes));
*/
		
		//获取参数的乱码问题
//		String username = request.getParameter("username");
//		System.out.println("解决前:username="+username);
		
		//如果是POST提交,可以按照下面这种方式解决乱码
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println("解决前:username="+username);

		//通用解决方式:不管是GET还是POST都会起作用
//		byte[] bs = username.getBytes("iso8859-1");
//		username = new String(bs, "utf-8");
//		System.out.println("解决后:username="+username);
//		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
