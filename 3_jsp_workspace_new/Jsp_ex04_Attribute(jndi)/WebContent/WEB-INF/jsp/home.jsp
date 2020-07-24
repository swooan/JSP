<%@page import="org.comstudy21.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Home Page</h1>
	<hr>
	<%
		Person person = (Person)request.getAttribute("person");
	%>
	
	1. 사용자 이름 : <%=person.getUserName()%> <br>
	2. 사용자 주소 : <%=person.getUserAddr()%> <br>
	3. 사용자 나이 : <%=person.getAge() %> <br>

</body>
</html>