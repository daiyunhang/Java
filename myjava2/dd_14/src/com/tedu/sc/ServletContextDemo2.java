package com.tedu.sc;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	
 */
public class ServletContextDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取SservletScontext对象
		ServletContext sc = this.getServletContext();
		
		//2.获取ServletContext对象中的数据
		String name = (String)sc.getAttribute("name");
		String nickname = (String)sc.getAttribute("nickname");
		int age = (Integer)sc.getAttribute("age");
		System.out.println(name+":"+nickname+":"+age);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
