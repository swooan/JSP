package org.comstudy21.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// 한글을 쓸 수 있게 만들어주는 필터

public class EncodeFilter implements Filter {
	ServletContext context;

	@Override
	public void init(FilterConfig config) throws ServletException {
		context = config.getServletContext();

	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		
		// request filter
		context.log("request filter");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		req.setAttribute("prefix", "/WEB-INF/views");
		req.setAttribute("suffix", ".jsp");
		String ctxPath = request.getContextPath();
		String reqUri = request.getRequestURI();
		int beginIndex = ctxPath.length() +1; 
		int endIndex = reqUri.lastIndexOf(".");
		String path = reqUri.substring(beginIndex, endIndex);
		req.setAttribute("path", path);
		
		
		chain.doFilter(req, resp);
		// response filter
		context.log("response filter");

	}

	

	@Override
	public void destroy() {}
	
	public boolean test() {
		
		return false;
	}
}
