<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Object</title>
</head>
<body>
	<h1>Internal Object Test</h1>
	<hr>
	<table border=1>
		<tr>
			<th>Name</th>
			<th>Birth</th>
		</tr>
		<tr>
			<td><%=request.getParameter("name")%></td>
			<td><%=request.getParameter("birthday")%></td>
		</tr>
	</table>
</head>
<body>

</body>
</html>