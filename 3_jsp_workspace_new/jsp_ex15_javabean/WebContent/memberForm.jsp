<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member Form</title>
</head>
<body>

<form action="member.jsp" method="post">
<h1>회원정보 등록 폼</h1>
<table border="1" cellpadding="5" cellspacing="0" width="600" bordercolordark="white" bordercolorlight="dark">
	<tr>
		<td width="200">
		<p align="right">사용자 이름</p></td>
		<td width="400"><input type="text" name="name" /></td>
	</tr>
	<tr>
		<td width="200"><p align="right">나이</p></td>
		<td width="400"><p><input type="text" name="age" /></p></td>
	</tr>
	<tr>
		<td width="200"><p align="right">몸무게</p></td>
		<td width="400"><p><input type="text" name="weight" /></p></td>
	</tr>
	<tr>
		<td width="200"><p align="right">키</p></td>
		<td width="400"><p><input type="text" name="height" /></p></td>
	</tr>
	<tr>
		<td width="200"><p align="right">성별</p></td>
		<td width="400"><p><input type="text" name="gender" /></p></td>
	</tr>
	<tr>
		<td width="200"><p>&nbsp</p></td>
		<td width="400"><input type="submit" value="보내기" /><input type="reset" /></td>
	</tr>
</table>
</form>
</body>
</html>