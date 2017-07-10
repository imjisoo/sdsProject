<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>JUNGDUCK92</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
#container {
	width: 800px;
	margin: auto;
	margin-top: 10%;
}
.red {
	color: red;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		
		$("#findIdSubmit").click(function () {
			
			var findIdEmail = $("input[name='findIdEmail']").val();
			
			if (findIdEmail.length == 0) {
				
				$("#warningResult").html("<h1 class='red'>이메일을 입력하시오.</h1>");
				$("#warningPopUp").css("display", "block");
				
				return false;
				
			}
			
			return true;
			
		});
		
		$("#findPwSubmit").click(function () {
			
			var findPwId = $("input[name='findPwId']").val();
			var findPwEmail = $("input[name='findPwEmail']").val();
			
			if (findPwId.length == 0) {
				
				$("#warningResult").html("<h1 class='red'>아이디를 입력하시오.</h1>");
				$("#warningPopUp").css("display", "block");
				
				return false;
				
			} else if (findPwEmail.length == 0) {
				
				$("#warningResult").html("<h1 class='red'>이메일을 입력하시오.</h1>");
				$("#warningPopUp").css("display", "block");
				
				return false;
				
			}
			
			return true;
			
		});
		
	});
</script>
</head>
<body>
	<div class=w3-card-4 id="container">
		<header class="w3-container w3-teal"><h1>FIND INFORMATION</h1></header>
		<div class="w3-container w3-margin">
			<div class="w3-half">
				<form action="findMemberId.jd" method="post">
					<table class="w3-table">
						<tr>
							<td colspan="2">아이디 찾기</td>
						</tr>
						<tr style="height: 88px;">
							<th style="vertical-align: middle;">EMAIL</th>
							<td style="vertical-align: middle;"><input type="text" name="findIdEmail" /></td>
						</tr>
						<tr>
							<td colspan="2" class="w3-right-align"><input type="submit" value="아이디찾기" id="findIdSubmit"/></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="w3-half">
				<form action="findMemberPw.jd" method="post">
					<table class="w3-table">
						<tr>
							<td colspan="2">비밀번호 찾기</td>
						</tr>
						<tr>
							<th>ID</th>
							<td><input type="text" name="findPwId" /></td>
						</tr>
						<tr>
							<th>EMAIL</th>
							<td><input type="text" name="findPwEmail" /></td>
						</tr>
						<tr>
							<td colspan="2" class="w3-right-align"><input type="submit" value="비밀번호찾기" id="findPwSubmit" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
	</div>
	<div id="warningPopUp" class="w3-modal">
		<div class="w3-modal-content">
			<header class="w3-container w3-teal"> 
				<span onclick="document.getElementById('warningPopUp').style.display='none'" class="w3-button w3-display-topright">&times;</span>
				<h2>WARNING</h2>
			</header>
			<div class="w3-container" id="warningResult">
				
			</div>
			<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
		</div>
	</div>
	<c:if test="${not empty resultStatement }">
		<div id="findIdResultPopUp" class="w3-modal" style="display: block;">
			<div class="w3-modal-content">
				<header class="w3-container w3-teal"> 
					<span onclick="document.getElementById('findIdResultPopUp').style.display='none'" class="w3-button w3-display-topright">&times;</span>
					<h2>WARNING</h2>
				</header>
				<div class="w3-container">
					${resultStatement }
				</div>
				<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
			</div>
		</div>
	</c:if>
</body>
</html>