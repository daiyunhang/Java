package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʵ�ֶ�ʱˢ��
 */
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ע��ɹ�,��ʾ�û�3��֮����ת����ҳ
//		request.setCharacterEncoding("");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��ϲ��ע��ɹ�,3��֮�󽫻���ת����ҳ...");
		
		//��ʱˢ��:3�����ת����ҳ
		response.setHeader("Refresh","3;url=/dd_14/index.html");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}