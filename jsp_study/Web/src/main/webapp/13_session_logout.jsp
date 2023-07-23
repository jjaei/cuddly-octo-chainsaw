<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();   // 전체 삭제
	// session.removeAttribute("userid");   특정 속성만 삭제
%>

<script>
	location.href="13_session_login.jsp";
</script>