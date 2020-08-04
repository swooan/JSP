<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
<%request.setCharacterEncoding("utf8");
response.setCharacterEncoding("utf8");
response.setContentType("text/html; charset=utf8"); %>

	<form method="post" action="delete.jsp">
	<input type='hidden' name="id" value="">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="list.jsp">홈으로 바로가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>