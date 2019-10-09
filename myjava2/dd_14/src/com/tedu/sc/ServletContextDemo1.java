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
		//1.��ȡServletContext����
		ServletContext sc = this.getServletContext();
		
		//2.��ServletContext�����������
		sc.setAttribute("name", "������");
		sc.setAttribute("nickname", "С���");
		sc.setAttribute("age", 18);
		System.out.println("�����Ѵ���ServletContext"+"����...");
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
