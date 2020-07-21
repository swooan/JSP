package org.comstudy21;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet Profile ... ");
		
		String path = "/WEB-INF/jsp/Profile.jsp";
		
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req, resp);
	}
}
