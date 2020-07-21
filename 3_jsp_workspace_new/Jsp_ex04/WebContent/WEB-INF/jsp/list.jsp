<%@page import="org.comstudy21.dto.Person"%>
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

	<h1>사용자 목록</h1>
	<hr>
	<%
		ArrayList<Person> pList = (ArrayList<Person>)request.getAttribute("P_LIST");
		for(int i = 0; i < pList.size(); i++) {
			out.println("사용자 이름 : " + pList.get(i).getUserName()); %>
			<br>
			<% out.println("사용자 주소 : " + pList.get(i).getUserAddr()); %>
			<br>
			<% out.println("사용자 나이 : " + pList.get(i).getAge()); %>
			<br>
			<br>
		<%
		}
		// end of for
		%>

</body>
</html>