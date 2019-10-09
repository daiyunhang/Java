package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//模拟查询个人信息
		String name = "刘德华";
		String age = "18";
		String nickname = "华仔";
		String addr = "香港";
		
		//将个人信息存入到request域中
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("nickname", nickname);
		request.setAttribute("addr", addr);
		
		//通过转发将request域带到jsp,在jsp中取出
		//request域中的数据,进行显示
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
