<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="http://localhost:8088/jsp_ex19_customtag/SimpleBodyLoopTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border=1>
		<tr>
			<td>이름</td>
		</tr>
		<tag:simpleBodyLoop>
		<tr>
			<td>${data}</td>
		</tr>
		</tag:simpleBodyLoop>
	</table>

</body>
</html>