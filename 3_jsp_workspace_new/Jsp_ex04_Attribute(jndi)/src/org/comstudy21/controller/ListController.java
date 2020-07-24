package org.comstudy21.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dto.Person;

public class ListController extends HttpServlet {
	
	private ArrayList<Person> pList = new ArrayList<>();
	{
		pList.add(new Person("KIM","서울시",20));
		pList.add(new Person("LEE","대전시",20));
		pList.add(new Person("PARK","인천시",20));
		pList.add(new Person("CHOI","부산시",20));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet - ProfileController");
		
		req.setAttribute("P_LIST", pList);
		
		String path = "/WEB-INF/jsp/list.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req, resp);
	}
	
}
