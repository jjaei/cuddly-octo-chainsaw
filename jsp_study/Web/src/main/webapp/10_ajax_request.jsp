<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Communication</title>
</head>
<body>
	<%
	String city = request.getParameter("city");
	String zipcd = request.getParameter("zipcd");
	
	try {
		Thread.sleep(3000);
	} catch(Exception e){}
	
	out.println("당신이 찾는 동네는 " + city + " 안에 있는 곳인가요?");
	out.println("<br>");
	out.println(zipcd);
	%>
</body>
</html>