<%@page import="java.util.ArrayList"%>
<%@page import="model.*" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 1단계 : useBean 태그로 자바 빈을 생성한다
    		scope는 page, request, session, application 4가지이다.(생략시 기본 = page) -->
    <!-- javabean => MemberBean -->
	<jsp:useBean id="m" class="model.MemberBean" />  
	
	<!-- 2단계 : setProperty 태그로 속성값을 저장한다. -->
	<!-- 3단계 param을 이용한다. HTML의 파라미터명을 지정한다. -->
		<%--3단계 이후 value 삭제 --%>
	<!-- 4단계 param을 생략할 수 있다. HTML의 파라미터 이름과 자바빈의 속성명이 같으면 생략한다. -->	

	<!-- 5단계 property를 수정한다. HTML과 자바빈이 모두 일치하면 property값을 *로 수정한다. -->
	<jsp:setProperty name="m" property="*" />
	
    
 <%
 	request.setCharacterEncoding("UTF8");
 	/* 2단계 이후 삭제*/
 	/*
 	String userName = request.getParameter("name");
 	String userAge = request.getParameter("age");
 	String userWeight = request.getParameter("weight");
 	String userHeight = request.getParameter("height");
 	String userGender = request.getParameter("gender"); */
 	
 	/*1단계 이후 생략 가능*/
 	/*MemberTO m = new MemberTO(userName, userAge, userWeight, userHeight, userGender); */
 	
 	/*1단계 이후 생성*/
 	/*2단계 이후 삭제*/
 	/* m.setName(userName);
 	m.setAge(userAge);
 	m.setWeight(userWeight);
 	m.setHeight(userHeight);
 	m.setGender(userGender); */
 	
 	MemberDAO memDAO = new MemberDAO();
 	memDAO.insertMember(m);
 	ArrayList<MemberBean> list = memDAO.showMember();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" border="0" cellpadding="2" cellspacing="1" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
		<td width="7%" bgcolor="#336699">
			<p align="center"><font color="white"><b><span style="fontsize:9pt;">이름</span></b></font></p>
		</td>
		<td width="5%" bgcolor="#336699">
			<p align="center"><font color="white"><b><span style="fontsize:9pt;">나이</span></b></font></p>
		</td>
		<td width="11%" bgcolor="#336699">
			<p align="center"><font color="white"><b><span style="fontsize:9pt;">체중</span></b></font></p>
		</td >
		<td width="5%" bgcolor="#336699">
			<p align="center"><font color="white"><b><span style="fontsize:9pt;">키</span></b></font></p>
		</td>
		<td width="7%" bgcolor="#336699">
			<p align="center"><font color="white"><b><span style="fontsize:9pt;">성별</span></b></font></p>
		</td>
	</tr>
	
	<%
		if(list.size() == 0) {
	%>
	<tr>
		<td colspan="5">
			<p align="center"><b><span style="font-size:9pt;">등록된 회원이 없습니다.</span></b></p>
		</td>
	</tr>
	<% } else { %>
	<tr height="1" bgcolor="#336699">
		<td>지금 입력된 사용자 나이는? <jsp:getProperty name="m" property="age" /> 입니다.</td>
	</tr>
	<%} %>
</table>

</body>
</html>