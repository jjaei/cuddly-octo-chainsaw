<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	
	// userid와 passwd check
	if(userid.equals("apple") && passwd.equals("1111")){
		session.setAttribute("userid", userid);
		response.sendRedirect("13_session_login.jsp");
	} else {
%>
	<script>
		alert("로그인 정보가 일치하지 않습니다.");
		location.href = "13_session_login.jsp";
	</script>		
<%		
	}
%>