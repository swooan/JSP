package org.comstudy21;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// annotation(@) : web.xml에 servlet-mapping 을 설정 안해도 된다.
// @WebServlet(url-pattern)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("HelloServlet 찍고...");
		
		response.getWriter()
		.append("HelloServlet")
		.append(request.getContextPath());
	
		boolean isRedirect = new Boolean(request.getParameter("bool"));
		String path = "/toHello";
		
		request.setAttribute("message", "Hello Servlet world");
		
		if(isRedirect) {
			// response 는 메세지 전달이 안된다.
			response.sendRedirect(request.getContextPath() + path);
		}
		else {
			// Dispatch 방식 - forward : forward 되는 페이지에서 리소스 그대로 사용 가능.
			// dispatch 방식은 메세지가 전달 된다.
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}

}
