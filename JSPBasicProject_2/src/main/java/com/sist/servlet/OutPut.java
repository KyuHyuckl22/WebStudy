package com.sist.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutPut
 */
@WebServlet("/OutPut")
public class OutPut extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("OutputServlet:init() call..");
	}


	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("OutputServlet:destroy() call...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OutputServlet:doGet() call..");
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("OutputServlet:doPost() call..");
		/*
		 *   HTTP 상태 405 - 허용되지 않는 메소드
		 *   GET => doGET() / POST => doPost()
		 *   GET => doPost() (X) <a> => GET 방식
		 */
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
