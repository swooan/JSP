<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="saram" class="jsp_ex17_EL.saram"></jsp:useBean>
<jsp:setProperty property="*" name="saram"/>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>번호 : <span>${saram.no }</span></p>
	<p>성명 : <span>${saram.name }</span></p>
	<p>이메일 : <span>${saram.email }</span></p>

</body>
</html>