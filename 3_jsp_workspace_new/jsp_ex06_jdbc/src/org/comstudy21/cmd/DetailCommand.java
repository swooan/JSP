package org.comstudy21.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("No => " + no);
		
		return "detail";
	}

}
