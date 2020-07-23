package jsp_ex08_sessionAutoClose;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session.do")
public class SessionTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		out.println("Session ID : " + session.getId()+"<br>");
		out.println("Creation Time : " + new Date(session.getCreationTime())+"<br>");
		out.println("LastAccessed Time" + new Date(session.getLastAccessedTime())+"<br>");
		out.println("Max Inactive Interval : " + session.getMaxInactiveInterval());
		
		session.setMaxInactiveInterval(30);
		
		if(session.isNew()) {
			out.print("NEW");
		}
		
		if(out != null) {
			out.close();
		}
		session.invalidate();
	}
}
