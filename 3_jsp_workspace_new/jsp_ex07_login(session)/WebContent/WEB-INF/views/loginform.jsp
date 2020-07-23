<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	label{
		display: inline-block;
		width: 100px;
	}
</style>

</head>
<body>

<h1>로그인</h1>
<hr />
<%
if(session.getAttribute("login.id") != null) {
	out.println("<h3>you already logged in</h3>");
	out.println("<a href=logout>log out</a>");
}
else {
	String url = response.encodeURL("login");
}
%>

<form action="login" method="POST">
<input type="hidden" name = "address" value="서울시 서대문구 홍제동" />
<input type="hidden" name = "email" value="kim@korea.com" />
<input type="hidden" name = "tel" value="010-1111-1111" />
<fieldset>
	<legend>로그인</legend>
	<label for="userId">사용자 아이디</label>
	<input type="text" name="userId" id="userId" value="kim" /><br />
	<label for="passwd">비밀번호</label>
	<input type="password" name="passwd" id="passwd" value="0000" /><br />
	<input type="submit" value="로그인" />
</fieldset>
</form>

</body>
</html>