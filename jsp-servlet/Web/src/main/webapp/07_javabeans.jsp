<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.it.db.MemberVO" %>
<%@ page import="com.it.db.MemberDAO" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean class="com.it.db.MemberVO" id="member" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBeans Test</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<h1>Welcome to JavaBeans!</h1>
	<hr>
	<jsp:setProperty property="memberno" name="member" value="100" />
	<jsp:getProperty property="memberno" name="member" />	
	<!-- name에 Woods를 넣고 가져와보기 -->
	<br>
	<jsp:setProperty property="name" name="member" value="Woods" />
	<jsp:getProperty property="name" name="member" />
	
	<!-- CSS: bootstrap -->
	<table class="table table-hover">
	<%
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> members = dao.select();
		for(int i=0; i<members.size(); i++){
	%>
		<tr>
			<td><%=members.get(i).getMemberno()%></td>
			<td><%=members.get(i).getId() %></td>
			<td><%=members.get(i).getName() %></td>
		</tr>
	<%
		}
	%>

	</table>
</body>
</html>