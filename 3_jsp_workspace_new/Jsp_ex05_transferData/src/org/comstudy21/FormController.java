package org.comstudy21;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/jsp/form.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// jsp에서 넘겨져 오는 데이터는 doPost에서 처리
		
		System.out.println("doPost => FormController" );
		String userId = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String interests[] = req.getParameterValues("interest");
		
		System.out.println(">>> user id : " + userId);
		System.out.println(">>> user pw : " + passwd);
		for(int i=0; i<interests.length; i++) {
			System.out.println(">>> interest : " + i + ". " + interests[i]);			
		}
		
		Enumeration<String> enu = req.getParameterNames();
		while(enu.hasMoreElements()) {
			String paramName = (String)enu.nextElement();
			
			if(req.getParameterValues(paramName).length == 1) {
				String value = req.getParameter(paramName);
				System.out.println(paramName + " : " + value);
			}
			else {
				// 파라미터가 1보다 크면 배열이다.
				String[] arr = req.getParameterValues(paramName);
				for(int i = 0; i < arr.length; i++) {
					System.out.println(">>>> " + i + " : " + arr[i]);
				}
			}
		}
		
		// 작업 수행 후 다시 돌아간다~
		resp.sendRedirect("index.html");
	}

}
