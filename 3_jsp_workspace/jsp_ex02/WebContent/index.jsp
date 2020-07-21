<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 선언부 : 멤버 필드를 선언 하는 부분
	public String userName = "길동이";
	public void sayHello() {
		System.out.println("Hello world"); // 브라우저에 출력되는게 아닌 콘솔에 출력된다.
	}
%>
<%
	// 스크립트 릿 : _service() 함수의 내부 => 지시어
	sayHello();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- JSP 주석문  --%>
	<%-- 표현식: <%= 변수나 데이터%> => HTML 문서에 바로 출력된다. --%>
	<h1><%=userName%>의 홈페이지</h1>
	<hr>
	<ul>
		<li><a href="hello.do">HelloServelet 요청</a></li>
	</ul>

</body>
</html>