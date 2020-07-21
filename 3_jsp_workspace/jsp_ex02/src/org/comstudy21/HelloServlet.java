package org.comstudy21;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init ....");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method ....");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("hello servlet .... doGet");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<h1>hello servlet!!</h1>");
		out.print("</body></html>");
		out.close();
	}

}
