package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	// URL 패턴으로 요청 받는다.
	
	private HandlerMapping ctrlHandlerMap = new HandlerMapping();
	private ServletContext context = null;

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = (String)req.getAttribute("path");
		context = getServletContext();
		
		path = path.substring(0, path.indexOf("/"));
		
		context.log(">>>>> path : " + path);
		
		Controller ctrl = ctrlHandlerMap.getController(path);
		ModelAndView view = ctrl.service(req, resp);
		view.forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
}
