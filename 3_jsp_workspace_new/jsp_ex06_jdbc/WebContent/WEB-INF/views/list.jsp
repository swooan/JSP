<%@page import="org.comstudy21.model.SaramDto"%>
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

<h1>사람 정보 목록</h1>
<hr />

<%
	if(request.getAttribute("LIST") != null) {
		ArrayList<SaramDto> list = (ArrayList<SaramDto>)request.getAttribute("LIST");
%>
<table border = "1" width = "550">
<tr>
	<th>NO</th>
	<th>NAME</th>
	<th>E-MAIL</th>
	<th>PHONE</th>
</tr>
<%	
		for(SaramDto dto : list) {
%>
		<tr>
			<td><%=dto.getNo() %></td>
			<td><a href="detail.do?no=<%=dto.getNo() %>"><%=dto.getName() %></a></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getPhone() %></td>
		</tr>
<%		
		}
%>
</table>
<%	
	}
	else {
		out.println("<h3>내용이 없습니다.!</h3>");
	}
%>

</body>
</html>