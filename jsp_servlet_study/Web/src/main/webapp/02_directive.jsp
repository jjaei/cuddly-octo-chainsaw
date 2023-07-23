<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="Date Class를 이용한 현재 날짜 출력하기" %>
<%@ page import="java.util.Date" %>
<%@ page errorPage="03_error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive Example</title>
</head>
<body>
	<h1>현재 시간을 알려드립니다.</h1>
	<hr>
	<p>Today is <%= new Date() %></p>
	<% String date = null;
	// date.charAt(0);
	%>
</body>
</html>