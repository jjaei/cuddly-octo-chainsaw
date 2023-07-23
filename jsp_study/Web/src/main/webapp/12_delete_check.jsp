<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Cookie Check</title>
</head>
<body>
<%
	String cookie_check = request.getHeader("Cookie");
	System.out.println(cookie_check);
	if(cookie_check == null){
%>		
		<h1> 쿠키가 하나도 없습니다. </h1>

<%		
	} else {
		Cookie[] cookies = request.getCookies();
		boolean cookie_yn = false;
			for(Cookie c : cookies){
				if(c.getName().equals("id"))
					cookie_yn = true;
			}
				if(!cookie_yn){
%>		
				<h1> 쿠키(id)가 없습니다. </h1>
<%			
				}
		}
%>
</body>
</html>