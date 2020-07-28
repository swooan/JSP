<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	div, header, footer {
		border: 0px solid gray;
		border-radius: 10px;
	}
	#page {
		width: 1000px;
		margin : 0 auto;
	}
	div.left {
		width : 200px;
		background-color: #aaa;
	}
	div.main {
		width : 790px;
	}
	div.left, div.main {
		height: 400px;
		float : left;
	}
	#menu {
		background-color: #aaa;
		margin-bottom: 5px;
		text-align: center;
		padding : 10px;
	}
</style>

</head>
<body>

<div id="page">
	<!-- header include : start -->
	<%-- <%@ include file="/inc/header.jsp" %>--%>
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<!-- header include : end -->
	
	<!-- middle include : start -->
	<%--<%@ include file="/inc/middle.jsp" %>--%>
	<jsp:include page="/inc/middle.jsp"></jsp:include>
	<!-- middle include : end -->

	<!-- footer include : start -->
	<%--<%@ include file="/inc/footer.jsp" %>--%>
	<jsp:include page="/inc/footer.jsp"></jsp:include>
	<!-- footer include : end -->
</div>

</body>
</html>