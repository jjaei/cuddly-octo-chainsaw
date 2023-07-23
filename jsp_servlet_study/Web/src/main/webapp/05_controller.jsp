<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controller</title>
</head>
<body>
	<% 
		String site = request.getParameter("site");
		String url = "";
		
		System.out.println("Controller Called : " + site);
		
		if(site.equals("naver")){
			url = "05_forward_naver.jsp";
		} else if(site.equals("youtube")){
			url="05_forward_youtube.jsp";
		} else if(site.equals("google")){
			url="05_forward_google.jsp";
		}
	%>
	
	<jsp:forward page="<%=url%>" />
</body>
</html>