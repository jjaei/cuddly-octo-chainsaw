<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Membership</title>
</head>
<body>
	<!-- 
	1. 입력한 이름을 09_join_ok.jsp로 전송하기
	2. dao에서 이름 검색하는 메서드 사용하기
	3. 결과에 따라 알맞는 페이지로 응답하기
	4. join.jsp로 중복 여부 전송
	5. 09_join.jsp는 중복 여부에 따라 알맞는 메세지 출력하기
	-->
	
	<%
		String check = request.getParameter("check");
		String name = request.getParameter("name");
		
		if(check==null){
			check="";
		}
		
		if(name==null){
			name="";
		}
		
	%>
	
	<h1>Join Our Luxury Club</h1>
	<hr>
	
	<input type="hidden" value="<%=check%>" name="check">
	
	<form action="09_join_ok.jsp" name="joinForm">
		<fleidset>
			<legend>Fill the Blank</legend>
			이름 : <input type="text" name="name" value="<%=name%>"><br>
			결과 : <p id="result"></p>
			<input type="submit" value="Transfer" />
		</fleidset>
	</form>
</body>
<script src="//code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	var check = $("input[name='check']").val();
	if(check != ""){
		if(check == "true"){  // check가 중복일 경우
			$("p#result").text("중복");
		} else {  // 중복이 아닐 경우
			$("p#result").text("가입을 축하드립니다.");
		}
	}
</script>
</html>