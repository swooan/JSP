package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAttributeGet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession sess = req.getSession();
		
		String ctxMesg = (String)ctx.getAttribute("context");
		String sesMesg = (String)sess.getAttribute("session");
		String reqMesg = (String)req.getAttribute("request");
		
		String mesg = "context값 >>> " + ctxMesg + " Session 값 >>> " + sesMesg + " request 값 >>> " + reqMesg;
		out.print(mesg);
		
		// 동일 브라우져에서 set과 get을 실행하면 context값과 session값은 넘어오고 req 값은 안넘어온다.
		// 다른 브라우져에서 set과 get을 실행하면 context값만 넘어간다.
	}
	
}
