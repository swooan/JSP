<%@page import="java.sql.Date"%>
<%@page import="Model.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>book_id</th>
		<th>title</th>
		<th>pubs</th>
		<th>pub_date</th>
		<th>author_name</th>
	</tr>
	
	<%
			if(request.getAttribute("slist") != null) {
				ArrayList<Dto> list = (ArrayList<Dto>)request.getAttribute("slist");
			
				for(int i=0; i<list.size(); i++){
			Dto dto = list.get(i);
			int book_id = dto.getBook_id();
			String title = dto.getTitle();
			String pubs = dto.getPubs();
			Date pub_date = dto.getPub_date();
			String author_name = dto.getAuthor_name();
		%>
	
		<tr>
			<td><%=book_id %></td>
			<td><%=title %></td>
			<td><%=pubs %></td>
			<td><%=pub_date %></td>
			<td><%=author_name %></td>
		</tr>
	<%
		}
	}
	%>
</table>

</body>
</html>