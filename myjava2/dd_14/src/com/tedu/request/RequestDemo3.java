package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * .ʵ������ת��
 */
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestDemo3.doGet()");
		
		//������ת����RequestDemo4����
		/*
		 *	 ����ת��ֻ����ͬһ��WebӦ���ڲ���Դ֮�����ת
		 *	�����ǲ�ͬ��WebӦ�û��߲�ͬ����������֮����Դ
		 *	����ת!!
		 *	�����ת��ʱ,ת����·��ֻ��Ҫд��Դ��·��,����Ҫ
		 *	д�������ƺ�WebӦ�õ�����·��
		 */
		request.getRequestDispatcher("/RequestDemo4").forward(request, response);;
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
