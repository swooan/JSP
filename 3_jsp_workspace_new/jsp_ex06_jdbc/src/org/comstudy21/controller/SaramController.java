package org.comstudy21.controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.cmd.Command;
import org.comstudy21.cmd.DetailCommand;
import org.comstudy21.cmd.InsertCommand;
import org.comstudy21.cmd.ListCommand;

@WebServlet("/saram/*")
public class SaramController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ServletContext context;
	String ctxPath;
	
	Hashtable<String, Command> cmdMapper = new Hashtable<>();
	
	public SaramController() {
		cmdMapper.put("list", new ListCommand());
		cmdMapper.put("input", new InsertCommand());
		cmdMapper.put("detail", new DetailCommand());
	}
	
	public String mkPath(HttpServletRequest request, HttpServletResponse response) {
		
		String reqUri = request.getRequestURI();
		ctxPath = request.getContextPath();
		int beginIndex = ctxPath.length() + "/saram/".length();
		String path = reqUri.substring(beginIndex);
		path = path.substring(0, path.lastIndexOf("."));
		context.log(">>>> path : " + path);
		request.setAttribute("path", path);
		
		return path;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context = getServletContext();
		
		String path = mkPath(request, response);
		
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		String viewName = "form";
		boolean isRedirect = false;
		
		viewName = cmdMapper.get(path).run(request, response);
		
		if(isRedirect) {
			response.sendRedirect(ctxPath + "/" + viewName);
		} 
		else {
			viewName = prefix + viewName + suffix;
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context = getServletContext();
		
		String path = mkPath(request, response);
		
		InsertCommand cmd = (InsertCommand)cmdMapper.get(path);
		String viewName = cmd.update(request, response); 
		
		response.sendRedirect(ctxPath + "/saram/" + viewName + ".do");
	}

}
