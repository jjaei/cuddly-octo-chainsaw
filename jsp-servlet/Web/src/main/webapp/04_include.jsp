<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Example</title>
</head>
<body>
	<!-- header 영역 입니다. -->
	<%@ include file="04_header.jsp" %>
	
	<h2> 이 부분은 협찬이 아닙니다. </h2>
	
	<!-- footer 영역 입니다. -->
	<%@ include file="04_footer.jsp" %>
</body>
</html>