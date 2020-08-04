package test.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.command.Command;
import test.web.command.ListCommand;
import test.web.command.WriteCommand;


@WebServlet(description = "boardfrontcontroller", urlPatterns = { "/board" })
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		System.out.println("FrontController 호출");
		String action = request.getParameter("action");
		String viewName = "/WEB-INF/views/board/list.jsp";
		
		// 목록보기
		try {
			if("list".equals(action)) {
				// command 호출
				Command command = new ListCommand();
				command.execute(request, response);
				
				viewName = "/WEB-INF/views/board/list.jsp";
			} else if("write.ui".equals(action)){
				viewName = "/WEB-INF/views/board/write.jsp";
			}
			else if("write.do".equals(action)){
				System.out.println("1234578");
				// command 호출
				WriteCommand command = new WriteCommand();
				command.execute(request, response);
				
				response.sendRedirect("board?action=list");
				return;
			}
			
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
