<%@page import="org.comstudy21.SaramBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<SaramBean> list = new ArrayList<>();
	list.add(new SaramBean(0, "홍길동", "010-1111-1111"));
	list.add(new SaramBean(1, "이순신", "010-2222-2222"));
	list.add(new SaramBean(2, "안중근", "010-3333-3333"));
	list.add(new SaramBean(3, "정약용", "010-4444-4444"));
	request.setAttribute("list", list);
%>

<!-- JSTL의 forEach태그를 이용해서 list 목록을 출력하라. -->

	<c:forEach var="l" items="${list }">
		<p>
		no : <c:out value="${l.no }"></c:out><br />
		name : <c:out value="${l.name }"></c:out><br />
		phone : <c:out value="${l.email }"></c:out><br />
		</p>
	</c:forEach>

</body>
</html>