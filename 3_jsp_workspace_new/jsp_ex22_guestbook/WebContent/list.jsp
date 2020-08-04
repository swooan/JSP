﻿<%@page import="model.GuestBookVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.GuestBookUtil"%>
<%@page import="model.GuestBookDao"%>
<%request.setCharacterEncoding("utf8");
response.setCharacterEncoding("utf8");
response.setContentType("text/html; charset=utf8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>


	<form action="add.jsp" method="POST">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
	
	<%
		GuestBookDao dao = GuestBookDao.getInstance();
		dao.setConnection(GuestBookUtil.getConnection());
		ArrayList<GuestBookVo> list = dao.List();
		
		for(GuestBookVo vo : list) {
	%>
	<table width=510 border=1>
		<tr>
			<td><%=vo.getNo() %></td>
			<td name = "dname"><%=vo.getName() %></td>
			<td><%=vo.getReg_date() %></td>
			<td><a href="<%=request.getContextPath() %>/deleteform.jsp">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getContent() %></td>
		</tr>
	</table>
        <br/>
        <%
		}
        %>
	
</body>
</html>