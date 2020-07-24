<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Profile Page</h1>
	<hr>
	
	<%
		String userName = (String)request.getAttribute("USER_NAME");
		String userAddr = (String)request.getAttribute("USER_ADDR");
		int userAge = (int)request.getAttribute("USER_AGE");
	%>
	
	1. 사용자 이름 : <%=userName %> <br>
	2. 사용자 주소 : <%=userAddr %> <br>
	3. 사용자 나이 : <%=userAge %>

</body>
</html>