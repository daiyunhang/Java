package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ģ���ѯ������Ϣ
		String name = "���»�";
		String age = "18";
		String nickname = "����";
		String addr = "���";
		
		//��������Ϣ���뵽request����
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("nickname", nickname);
		request.setAttribute("addr", addr);
		
		//ͨ��ת����request�����jsp,��jsp��ȡ��
		//request���е�����,������ʾ
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
