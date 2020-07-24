package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginForm extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("userID");
		String pw = req.getParameter("passwd");
		
		HttpSession session = req.getSession();
		if(session.isNew()) {
			session.setAttribute("login", id);
		}
		
		out.println("<html><body>");
		out.println("userID는 " + id + "<br />");
		out.println("password는 " + pw + "<br />");
		out.println("총 접속자 수는 " + SessionListener.activeSessions);
		out.println("</body></html>");
	}
}
