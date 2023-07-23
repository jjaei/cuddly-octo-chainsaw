<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<jsp:useBean class="com.it.db.MemberDAO" id="dao" />
<%
	String name = request.getParameter("name");
//	System.out.println(name);
	boolean check = dao.checkName(name);

	String name2 = URLEncoder.encode(name);
	response.sendRedirect("09_join.jsp?check=" + check + "&name=" + name2);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Result</title>
</head>
<body>
	
</body>
</html>