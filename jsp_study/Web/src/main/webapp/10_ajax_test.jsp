<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
</head>
<body>
	<h1>GET Request</h1>
	<button type="button" onclick="sendRequest(1)">send(GET)</button>
	<p id="gettext"></p>
	<hr>
	<h1>POST Request</h1>
	<button type="button" onclick="sendRequest(2)">send(POST)</button>
	<p id="posttext"></p>
	<hr>
	<h3>Request Status</h3>
	<p id="statustext"></p> 
</body>

<script>
	function sendRequest(typ){
		console.log(typ);
		
		// 1. XMLHttpRequest 객체 생성하기
		var hr = new XMLHttpRequest();
		if(typ == "1"){
			/* GET 방식 */
			hr.open("GET", "10_ajax_request.jsp?city=SEOUL&zipcd=06630", true);
			hr.send();
			document.getElementById("statustext").innerHTML = "GET 요청 중입니다. 잠시만 기다려주세요.";
		} else {
			/* POST 방식 */
			hr.open("POST", "10_ajax_request.jsp", true);
			hr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			hr.send("city=HEAVEN&zipcd=77777");
			document.getElementById("statustext").innerHTML = "POST 요청 중입니다. 잠시만 기다려주세요."
		}
		
		hr.onreadystatechange = function() {
			console.log("readyState was Changed : " + hr.readyState);
			if(hr.readyState == XMLHttpRequest.DONE && hr.status == 200){
				if(typ==1){
					document.getElementById("gettext").innerHTML = hr.responseText;
				} else {
					document.getElementById("posttext").inngerHTML = hr.responseText;
				}
				
				document.getElementById("statustext").innerHTML = "요청하신 처리가 완료되었습니다.";
			}
		}
	}
</script>

</html>