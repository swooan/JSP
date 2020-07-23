package org.comstudy21.login2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginTest extends HttpServlet {
	String loginId = "kim";
	String loginPass = "0000";
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/loginform.jsp";
		
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out  = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		if(session.isNew()) {
			out.print("<p>First Access!<br> new session created</p>");
		}
			String userId = req.getParameter("userId");
			String pass = req.getParameter("passwd");	
			
			if(session.getAttribute("login.id") != null) {
				out.println("<p>You already logged in</p>");
			}
			else if(userId.equals(loginId) && pass.equals(loginPass)) {
				session.setAttribute("login.id", userId);
				out.println("<p>login success</p>");
				out.println("");
			}
			else {
				out.println("<p>login fail</p>");
			}
			out.println("<p><a href=login>go to login page</a></p>");
	}

}
