<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.it.db.MemberDAO" id="dao" />
<%
	String name = request.getParameter("name");
//	System.out.println(name);
	boolean check = dao.checkName(name);
	response.sendRedirect("09_join.jsp?check=" + check + "&name=" + name);
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