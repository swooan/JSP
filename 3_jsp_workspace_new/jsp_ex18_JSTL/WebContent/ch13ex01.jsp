<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<jsp:useBean id="m" class="org.comstudy21.SaramBean"></jsp:useBean>
<jsp:setProperty property="name" name="m" value="an"/>
	
<c:set var="str" value="seo"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		request.setAttribute("message","Hello jsp world");
	%>
	
	<c:remove var="m"/>	
	
	<c:if test="${m.name == null }">
		<p>이름이 없습니다.</p>	
	</c:if>
	<c:if test="${m.name != null }">
		<p>noname : <c:out value="${m.name }"></c:out> </p>
	</c:if>
	
	<c:choose>
		<c:when test="${m.name == null }">
			<p>이름이 없습니다.</p>	
		</c:when>
		<c:when test="${m.name != null }">
			<c:remove var="m"/>
			<p>noname : <c:out value="${m.name }"></c:out> </p>
		</c:when>
	</c:choose>

	<p>Message : <c:out value="${message}"></c:out> </p>
	<p>name : <c:out value="${m.name }"></c:out> </p>
	<p>str : <c:out value="${str }"></c:out> </p>

</body>
</html>