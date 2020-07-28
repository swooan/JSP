<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>안녕 JSP 세계</h1>
	<p>반갑습니다.</p>
	<%
		out.print("<p>반가워요~</p>");
		
		// 실제 경로 : request.getRealPath
		// this : class로 바뀐 파일
		
		String path = request.getRealPath(this.getClass().getName().toString());
		out.println(path);
	%>
	<!-- 스크립트 릿 으로 만들어진 코드는 전부 public service 안으로 변환되어 들어간다. -->
</body>
</html>