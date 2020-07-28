package org.comstudy21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/*")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Hashtable<String, ArrayList<LeftItem>> leftMenuMap = new Hashtable<>();
	static {
		ArrayList<LeftItem> javaList = new ArrayList<>();
		javaList.add(new LeftItem("변수와 함수", "/java/ch01/?dir=db&page=db_ch01"));
		javaList.add(new LeftItem("클래스", "/java/ch02/"));
		javaList.add(new LeftItem("다형성", "/java/ch03/"));
		javaList.add(new LeftItem("객체지향", "/java/ch04/"));
		javaList.add(new LeftItem("디자인 패턴", "/java/ch05/"));
		leftMenuMap.put("java", javaList);
		
		ArrayList<LeftItem> databaseList = new ArrayList<>();
		databaseList.add(new LeftItem("DDL", "/database/ch01/"));
		databaseList.add(new LeftItem("DML", "/database/ch02/"));
		databaseList.add(new LeftItem("DCL", "/database/ch03/"));
		databaseList.add(new LeftItem("SQL", "/database/ch04/"));
		databaseList.add(new LeftItem("Backup", "/database/ch05/"));
		leftMenuMap.put("database", databaseList);
		
		ArrayList<LeftItem> servletList = new ArrayList<>();
		servletList.add(new LeftItem("S1", "/servlet/ch01/"));
		servletList.add(new LeftItem("S2", "/servlet/ch02/"));
		servletList.add(new LeftItem("S3", "/servlet/ch03/"));
		servletList.add(new LeftItem("S4", "/servlet/ch04/"));
		servletList.add(new LeftItem("S5", "/servlet/ch05/"));
		leftMenuMap.put("servlet", servletList);
		
		ArrayList<LeftItem> jqueryList = new ArrayList<>();
		jqueryList.add(new LeftItem("J1", "/jquery/ch01/"));
		jqueryList.add(new LeftItem("J2", "/jquery/ch02/"));
		jqueryList.add(new LeftItem("J3", "/jquery/ch03/"));
		jqueryList.add(new LeftItem("J4", "/jquery/ch04/"));
		jqueryList.add(new LeftItem("J5", "/jquery/ch05/"));
		leftMenuMap.put("jquery", jqueryList);
		
		ArrayList<LeftItem> pythonList = new ArrayList<>();
		pythonList.add(new LeftItem("P1", "/python/ch01/"));
		pythonList.add(new LeftItem("P2", "/python/ch02/"));
		pythonList.add(new LeftItem("P3", "/python/ch03/"));
		pythonList.add(new LeftItem("P4", "/python/ch04/"));
		pythonList.add(new LeftItem("P5", "/python/ch05/"));
		leftMenuMap.put("python", pythonList);
	}

	  public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  if(req.getParameter("page") != null) {
			  
			  String key = req.getParameter("page");
			  ArrayList<LeftItem> leftItem = leftMenuMap.get(key);
			  req.setAttribute("leftItems", leftItem);
			  
		  }
		  String viewName = "/WEB-INF/views/home.jsp";
		  RequestDispatcher view = req.getRequestDispatcher(viewName);
		  view.forward(req, resp);
	  }


		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			process(req,resp);
		}
	
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			process(req,resp);
		}

}
