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
		//��ȡ�û���
		String username = request.getParameter("username");
		System.out.println("username="+username);
		
		//��ȡ����
		String[] likes = request.getParameterValues("like");
		System.out.println("likes:"+Arrays.toString(likes));
*/
		
		//��ȡ��������������
//		String username = request.getParameter("username");
//		System.out.println("���ǰ:username="+username);
		
		//�����POST�ύ,���԰����������ַ�ʽ�������
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println("���ǰ:username="+username);

		//ͨ�ý����ʽ:������GET����POST����������
//		byte[] bs = username.getBytes("iso8859-1");
//		username = new String(bs, "utf-8");
//		System.out.println("�����:username="+username);
//		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
