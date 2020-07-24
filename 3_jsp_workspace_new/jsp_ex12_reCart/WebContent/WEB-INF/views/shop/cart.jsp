<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.comstudy21.model.Product"%>
<%@page import="org.comstudy21.controller.ShopController"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>장바구니</h1>
	<hr />
	
	<%
		if(session.getAttribute("cartList") != null) {
			
			HashSet<Product> cartList = (HashSet<Product>)session.getAttribute("cartList");
			
			Iterator iter = cartList.iterator();
			while(iter.hasNext()) {
				Product p = (Product)iter.next();	
	%>
			<p>no : <%=p.getIdx()%> / title : <%=p.getTitle() %> / price : <%=p.getPrice() %></p>
	<%		
			out.println("<p>"+p+"[<a href="+request.getContextPath()+"/shop/cart_remove.do?dix="+p.getIdx()+">카트에서 제거</a>]</p>");
			}
		}
	%>

	<a href="<%=request.getContextPath()%>/shop/home.do">홈으로</a>
	<a href="<%=request.getContextPath()%>/shop/list.do">목록으로 돌아가기</a>

</body>
</html>