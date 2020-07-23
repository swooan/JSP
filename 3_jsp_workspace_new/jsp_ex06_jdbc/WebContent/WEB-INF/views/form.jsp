<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사람 정보 입력</h1>
<hr />
<form action="input.do" id="input_form" method="POST">
	성명: <input type="text" name="name" value = "test" /><br />
	이메일: <input type="text" name="email" value = "test@test.com" /><br />
	전화: <input type="text" name="phone" value = "010-0000-0000" /><br />
	<input type="submit" value="전송하기" />
</form>

<script src="http://code.jquery.com/jquery.js"></script>
<script>
$('#input_form').submit(function() {
	event.preventDefault();
	
	// 유효성 체크
	this.method = "POST";
	this.submit();
});
</script>
</body>
</html>