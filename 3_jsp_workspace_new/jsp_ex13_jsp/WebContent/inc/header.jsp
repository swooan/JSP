<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
		<header>
			<h1>코딩교실</h1>
			<div id="menu">
				<a href="<%=request.getContextPath() %>/home/?page=home">HOME</a> |
				<a href="<%=request.getContextPath() %>/home/?page=java">JAVA</a> | 
				<a href="<%=request.getContextPath() %>/home/?page=database">Database</a> | 
				<a href="<%=request.getContextPath() %>/home/?page=servlet">Servlet/JSP</a> | 
				<a href="<%=request.getContextPath() %>/home/?page=jquery">jQuery</a> | 
				<a href="<%=request.getContextPath() %>/home/?page=python">Python</a>
			</div>
		</header>