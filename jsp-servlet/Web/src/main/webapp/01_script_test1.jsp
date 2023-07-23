<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Script Tag Example 1</title>
</head>
<body>
	<h1>Scripting Tag</h1>
	<hr>
	<%!
		int count = 5;
		String makeLower(String data) {
			return data.toLowerCase();
		}
	%>
	
	<%
		for(int i=0; i<count; i++){
			out.println("Java Server Age NO. " + i + "<br>");
	}
	%>
	
	<!-- Expression Tag -->
	<!-- semicolon을 쓰면 안 됨. -->
	<h3>My Name is Might and Magic</h3>
	<h3><%=makeLower("My Name is Might and Magic")%></h3>
</body>
</html>