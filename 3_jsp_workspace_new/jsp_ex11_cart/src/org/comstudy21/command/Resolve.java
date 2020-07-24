package org.comstudy21.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resolve {
	public boolean isRedirect = false;
	public String viewName = "";
	
	public Resolve() {}

	public Resolve(boolean isRedirect, String viewName) {
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}

	public void forward(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if(isRedirect) {
			resp.sendRedirect(req.getContextPath() + "/" + viewName);
		}
		else {
			viewName = req.getAttribute("prefix") + "/" + viewName + req.getAttribute("suffix");
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
		
	}
	
	
}
