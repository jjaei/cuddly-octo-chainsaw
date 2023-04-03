<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP Example</title>
</head>
<body>
	<h1>First JSP, at last...</h1>
	<hr>
	<form action="MyServlet" method="post">
		<p>MyServlet으로 Jump~</p>
		<button type="submit">Jump to MyServlet</button>
		<!-- 
			<input type="button"> : 눌러도 submit을 하지 않음. 버튼의 모습이긴 함. onclick 사용해서 써야 함.
			<input type="submit"> : 누르면 submit 함.
			<button></button> : 누르면 submit 함.
		-->
	</form><br>
</body>
</html>