package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �����ض���
 */
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResponseDemo2.doGet()");
		
		//�������ض���index.html(302+location)
		//response.sendRedirect("/dd_14/index.html");
		
		//�ض��򵽱��webӦ���µ���Դ
//		response.sendRedirect("/dd_web_13/SecondServlet");
//		response.sendRedirect("https://www.taobao.com");
		//�ض��򵽱�����������µ���Դ
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
