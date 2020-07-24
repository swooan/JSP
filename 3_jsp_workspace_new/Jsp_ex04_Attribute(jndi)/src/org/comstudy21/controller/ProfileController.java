package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileController extends HttpServlet {
	
	private String userName = "홍길동";
	private String userAddr = "서울시 종로구 견지동";
	private int age = 21;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet - ProfileController");
		
		String path = "/WEB-INF/jsp/profile.jsp";
		
		req.setAttribute("USER_NAME", userName);
		req.setAttribute("USER_ADDR", userAddr);
		req.setAttribute("USER_AGE", age);
		
		RequestDispatcher view = req.getRequestDispatcher(path);
		
		
		view.forward(req, resp);
	}
	
}
