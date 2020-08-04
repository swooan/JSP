<%@page import="util.GuestBookUtil"%>
<%@page import="model.GuestBookVo"%>
<%@page import="model.GuestBookDao"%>
<%
request.setCharacterEncoding("utf8");
response.setCharacterEncoding("utf8");
response.setContentType("text/html; charset=utf8");

out.println("add.jsp 진입");

GuestBookDao dao = GuestBookDao.getInstance();

String name = request.getParameter("name");
String password = request.getParameter("password");
String content = request.getParameter("content");

GuestBookVo vo = new GuestBookVo(0,name, password, content, null);

dao.setConnection(GuestBookUtil.getConnection());
dao.Insert(vo);

response.sendRedirect("list.jsp");
%>
