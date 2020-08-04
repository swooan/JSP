package controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.InsertCommand;
import command.ListCommand;

@WebServlet("/mail/*")
public class MailController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ServletContext context;
	String ctxPath;
	
	Hashtable<String, Command> cmdMapper = new Hashtable<>();
	
	public MailController() {
		cmdMapper.put("list", new ListCommand());
		cmdMapper.put("form", new InsertCommand());
	}
	
	protected String mkPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reqUri = req.getRequestURI();
		ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length() + "/mail/".length();
		String path = reqUri.substring(beginIndex);
		path = path.substring(0,path.lastIndexOf("."));
		req.setAttribute("path", path);
		
		return path;
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		context = getServletContext();
		
		String path = mkPath(req,resp);
		
		String prefix = "/WEB-INF/";
		String suffix = ".jsp";
		String viewName = "form";
		boolean isRedirect = false;
		
		viewName = cmdMapper.get(path).run(req, resp);
		
		if(isRedirect) {
			resp.sendRedirect(ctxPath + "/" + viewName + ".do");
		}
		else {
			viewName = prefix + viewName + suffix;
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		resp.setContentType("text/html; charset=utf8");
		
		context = getServletContext();
		
		String path = mkPath(req, resp);
		
		InsertCommand cmd = (InsertCommand)cmdMapper.get(path);
		String viewName = cmd.update(req, resp);
		
		resp.sendRedirect(ctxPath + "/mail/" + viewName + ".do");
	}
	
}
