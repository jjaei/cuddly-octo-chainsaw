<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Ajax Test</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<h1>JSON Ajax Test</h1>
	<hr>
	<div class="row justify-content-md-center">
		<div class="col-md-10">
		<table class="table table-hover">
			<tr>
				<td><h3>Realtime Search Ranking</h3></td>
				<td><div id="ranking">Keyword</div></td>
			</tr>
		</table>
		</div>
	</div>
</body>
<script>

	window.onload = function() {
		console.log("실행 중입니다.");
		var words = new Array();
		var obj = "";
		var ranking = document.getElementById("ranking");
		
		var hr = new XMLHttpRequest();
		hr.open("GET", "11_json_data.json", true);
		hr.send();
		console.log("send ok");
		
		hr.onreadystatechange = function() {
			console.log("status was change : " + hr.readyState);
			if(hr.readyState == 4) {
				if(hr.status == 200){
					console.log("Everything is OK");
					obj = JSON.parse(hr.responseText);
					
					for(var i=0; i<obj.search_word.length; i++) {
						str = "[" + obj.search_word[i].rank + "]" + obj.search_word[i].name;
						console.log(str);
						words[i] = str;
					}
				}else {
					console.log("status Problem!! " + hr.status);
				}
			}
		}
		
		var i = 0;
		var interval = setInterval(function(){
			if(i == obj.search_word.length){i = 0;}
			ranking.innerHTML = "<h3>" + words[i] + "</h3>";
			i++;
		}, 1000);
		
		console.log(interval);
		
		setTimeout(function() {
			clearInterval(interval);
		}, 20000);
	}
</script>
</html>