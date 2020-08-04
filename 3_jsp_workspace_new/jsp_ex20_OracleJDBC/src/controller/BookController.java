package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.SearchCommand;
import command.ShowCommand;


@WebServlet("/book/*")
public class BookController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		resp.setContentType("text/html; charset=utf8");
		
		String action = req.getParameter("action");
		String viewName = "/WEB-INF/list.jsp";
		
		try {
			if("list".equals(action)) {
				// command 호출
				Command command = new ShowCommand();
				command.run(req, resp);
				
				viewName = "/WEB-INF/list.jsp";
				
			} 
			else if("search".equals(action)) {
				Command command = new SearchCommand();
				command.run(req, resp);
				
				viewName="/WEB-INF/search.jsp";
				resp.sendRedirect("/book?action=search");
			}
			
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);

	}
	

}
