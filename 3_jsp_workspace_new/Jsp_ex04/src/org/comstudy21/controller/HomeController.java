package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dto.Person;

public class HomeController extends HttpServlet {
	
	private Person person = new Person("김길동", "대전", 28);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet - HomeController");
		
		req.setAttribute("person", person);
		
		String path = "/WEB-INF/jsp/home.jsp";
		
		RequestDispatcher view = req.getRequestDispatcher(path);
		
		view.forward(req, resp);
	}

}
