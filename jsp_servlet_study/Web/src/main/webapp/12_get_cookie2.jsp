<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String cookie_check = request.getHeader("Cookie");
		String id = "";
		
		if(cookie_check != null) {
			System.out.println("Cookie found!");
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				if(c.getName().equals("id")){
					System.out.println("[Cookie] " + c.getName() + ": " + c.getValue());
					id = c.getValue();
					break;
				}
			}
	%>
		<h1>User ID : <%=id%></h1>
		
	<%
			for(Cookie c : cookies) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
	%>
	<a href="12_delete_check.jsp">Click to Check Cookie Deletion</a>
</body>
</html>