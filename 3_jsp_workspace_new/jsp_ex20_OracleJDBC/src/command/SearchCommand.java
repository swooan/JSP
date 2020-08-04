package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dto;

public class SearchCommand implements Command {

	@Override
	public String run(HttpServletRequest req, HttpServletResponse resp) {
		
		String author_name = req.getParameter("search");
		Dto dto = new Dto(0,null,null,null,author_name);
		
		ArrayList<Dto> slist = dao.Search(dto);
		
		req.setAttribute("slist", slist);
		
		System.out.println(slist);
		
		return "search";
	}

}
