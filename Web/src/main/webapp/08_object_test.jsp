<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object Test</title>
</head>
<body>
	<h1>Object Test</h1>
	<hr>
	<form action="08_object_ok.jsp" name="join" method="get">
		<fieldset>
			<legend>Personal Info</legend>
			<input type="text" name="name">
			<input type="text" name="birthday">
			<input type="button" value="Confirm" onclick="sendIt()">
		</fieldset>
	</form>
</body>
<script src="//code.jquery.com/jquery-3.6.4.js"></script>
<script>
	function sendIt() {
		var frm = document.join;
		
		// 이름 미입력 시 
		if(frm.name.value == "") {
			$("input[name='name']").css('border-color', 'red');
			$("input[name='name']").attr('placeholder', '이름을 입력하세요.');
			return false;
		}
		
		// 생년월일 미입력 시
		if(frm.birthday.value == ""){
			// 테두리를 오렌지 색으로 바꾸고 return false
			$("input[name='birthday']").css('border-color', 'orange');
			return false;
		}
		
		frm.submit();
	}
</script>
</html>