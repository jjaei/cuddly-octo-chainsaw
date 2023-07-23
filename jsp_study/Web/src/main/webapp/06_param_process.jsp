<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response Page</title>
</head>
<body>
	<h1>Data Extract</h1>
	<hr>
	<p> ID : <%= request.getParameter("id") %></p>
	<p> NAME : <%= request.getParameter("name") %></p>
	<button><%= request.getParameter("name") %></button>
</body>
</html>