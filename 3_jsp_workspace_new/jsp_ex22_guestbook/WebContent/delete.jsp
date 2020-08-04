<%@page import="util.GuestBookUtil"%>
<%@page import="model.GuestBookVo"%>
<%@page import="model.GuestBookDao"%>
<%
request.setCharacterEncoding("utf8");
response.setCharacterEncoding("utf8");
response.setContentType("text/html; charset=utf8");

GuestBookDao dao = GuestBookDao.getInstance();

String password = request.getParameter("password");

GuestBookVo vo = new GuestBookVo(0,null, password, null, null);

dao.setConnection(GuestBookUtil.getConnection());
dao.Delete(vo);

response.sendRedirect("list.jsp");
%>