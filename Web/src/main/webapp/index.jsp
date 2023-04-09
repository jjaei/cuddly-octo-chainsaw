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
	<a href="01_script_test1.jsp">01_script_test1</a><br>
	<a href="01_script_test2.jsp">01_script_test2</a><br>
	<a href="01_script_test3.jsp">01_script_test3(현재 시간)</a><br>
	<a href="01_script_test4.jsp">01_script_test4(테이블)</a><br>
	<a href="02_directive.jsp">02_directive(현재 시간)</a><br>
	<a href="03_error_page.jsp">03_error_page</a><br>
	<a href="04_include.jsp">04_include(다른 페이지 포함하기)</a><br>
	<a href="05_forward_main.jsp">05_forward(다른 페이지 이동하기)</a><br>
	<a href="06_param_test.jsp">06_param_test(파라미터 넘겨주기)</a><br>
	<a href="07_javabeans.jsp">07_javabeans(자바빈즈)</a><br>
	<a href="08_object_test.jsp">08_Object</a><br>
	<a href="09_join.jsp">09_Join_example</a><br>
	<a href="10_ajax_test.jsp">10_Ajax</a><br>
	<a href="11_json_test.jsp">11_JSON_test</a><br>
	<a href="12_set_cookie.jsp">12_Cookie</a><br>
	<a href="13_session_login.jsp">13_Session</a><br>
</body>
</html>