<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<%
	String userid = "";
	if(session.getAttribute("userid") != null) {
		userid = (String)session.getAttribute("userid");	
%>	

	<h1><%=userid %> 님 환영합니다!!</h1>
	<hr>
	<a href="13_session_logout.jsp">[로그아웃]</a>

<%
	} else {
%>

	<form name="loginForm" method="post" action="13_session_login_ok.jsp">
		<fieldset>
			<legend>login info</legend>
			id <input type="text" name="userid">&nbsp;&nbsp;
			pw <input type="password" name="passwd">&nbsp;&nbsp;
			<input type="button" value="login" onclick="sendIt()">
		</fieldset>
	</form>
	
<%	
	}
%>	

</body>
<script>
	var frm = document.loginForm;
	function sendIt() {
		if(frm.userid.value == "") {
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(frm.passwd.value == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		frm.submit();
	}
</script>
</html>