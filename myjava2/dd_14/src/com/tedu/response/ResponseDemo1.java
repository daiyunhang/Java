package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  .��ͻ��˷�������
 */
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//��ֹ����
//		1.getOutputStream
		/*
		ServletOutputStream out = response.getOutputStream();
		out.write("hello".getBytes("utf-8"));
		out.write("���!".getBytes("utf-8"));
		System.out.println("������");
		*/
		
//		2.getWriter
		/*
		 * 1.���д����֪ͨ������ʹ��utf-8����������
		 * 2.����֪ͨ�����ʹ��tuf-8����������
		 */
		response.setContentType("text/html;charset=utf-8");//��ֹ����
		response.getWriter().write("���");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
