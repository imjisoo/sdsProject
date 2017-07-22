<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
		
		$("input.pwCheck").change(function () {
			
			var userPw = $("input[name='userPw']").val();
			var userPwCheck = $("input[name='userPwCheck']").val();
			
			if (userPw.length != 0 && userPwCheck.length != 0) {
				
				if (userPw != userPwCheck) {
					
					$("#checkPw").html("비밀번호가 일치하지 않습니다.");
					$("#checkPw").addClass("red");
					
				} else {
					
					$("#checkPw").html("비밀번호가 일치합니다");
					$("#checkPw").removeClass("red");
					
				}
				
			}
			
		});
		
		$("#changePwSubmit").click(function () {
			
			var userPw = $("input[name='userPw']").val();
			var userPwCheck = $("input[name='userPwCheck']").val();
			
			if (userPw.length < 4) {
				
				$("#warningResult").html("<h1 class='red'>유효하지 않은 비밀번호입니다.</h1>");
				$("#warningPopUp").css("display", "block");
				
				$("input[name='userPw']").val("");
				$("input[name='userPwCheck']").val("");
				
				return false;
				
			} else {
				
				var containNumber = 0;
				var containAlphabet = 0;
				
				for (var i = 0; i < userPw.length; i++) {
					
					var charCode = userPw.charCodeAt(i);
					
					if (charCode > 47 && charCode < 58) {
						
						containNumber = 1;
						
					} else if ((charCode > 64 && charCode < 92) || (charCode > 96 && charCode < 123)) {
						
						containAlphabet = 1;
						
					}
					
				}
				
				if (containNumber*containAlphabet == 0) {
					
					$("#warningResult").html("<h1 class='red'>유효하지 않은 비밀번호입니다.</h1>");
					$("#warningPopUp").css("display", "block");
					
					$("input[name='userPw']").val("");
					$("input[name='userPwCheck']").val("");
					
					return false;
					
				}
				
			}
			
		});
		
	});
</script>
</head>
<body>
	<div class=w3-card-4 id="container">
		<header class="w3-container w3-teal"><h1>CHANGE PASSWORD</h1></header>
		<div class="w3-container w3-margin">
			<form action="updateMemberPw.jd" method="post">
				<input type="hidden" name="memberIdx" value="${memberIdx }"/>
				<table class="w3-table">
					<col width="20%"/>
					<col width="80%"/>
					<tr>
						<th>PW</th>
						<td>
							<input type="password" name="userPw" class="pwCheck" />
							<span>4자리 이상, 문자와 숫자를 모두 포함해야 합니다.</span>
						</td>
					</tr>
					<tr>
						<th>PW CHECK</th>
						<td>
							<input type="password" name="userPwCheck" class="pwCheck" />
							<span id="checkPw"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="w3-right-align"><input type="submit" value="비밀번호 바꾸기" id="changePwSubmit"/></td>
					</tr>
				</table>
			</form>
		</div>
		<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
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
	</div>
</body>
</html>