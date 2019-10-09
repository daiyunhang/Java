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
public class ServletContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取ServletContext对象
		ServletContext sc = this.getServletContext();
		
		//2.往ServletContext对象存入数据
		sc.setAttribute("name", "阿凡达");
		sc.setAttribute("nickname", "小达达");
		sc.setAttribute("age", 18);
		System.out.println("数据已存入ServletContext"+"域中...");
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
