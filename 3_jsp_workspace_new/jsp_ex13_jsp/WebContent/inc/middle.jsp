<%@page import="org.comstudy21.LeftItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<div id = "middle">
		<div class = "left">
			<p>좌측 메뉴</p>
			<ul>
		<%
			if(request.getAttribute("leftItems") != null) {
				ArrayList<LeftItem> items = (ArrayList<LeftItem>)request.getAttribute("leftItems");
				for(LeftItem item : items) {
					out.println(item.getTag());
				}
			}
		%>
			</ul>
		</div>
		<div class = "main">
			<h3>메인</h3>
			<hr />
			<%
				// String subPage = request.getParameter("page");
				String subPage = "/inc/jsp/home.jsp";
				if(request.getParameter("page")!=null){
					subPage = request.getParameter("page");
					subPage = "/inc/jsp/" + subPage.trim() + ".jsp";
				}

			%>
			
			<!-- 액션 태그를 사용하면 변수와 함께 사용할 수 있다. -->
			<jsp:include page="<%=subPage %>"></jsp:include>

		</div>
	</div>
	