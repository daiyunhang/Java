package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现定时刷新
 */
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注册成功,提示用户3秒之后跳转到首页
//		request.setCharacterEncoding("");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("恭喜您注册成功,3秒之后将会跳转到首页...");
		
		//定时刷新:3秒后跳转到首页
		response.setHeader("Refresh","3;url=/dd_14/index.html");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
