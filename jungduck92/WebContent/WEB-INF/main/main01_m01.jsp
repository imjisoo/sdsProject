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
		
		$("input[name='userId']").change(function () {
			
			var userId = $("input[name='userId']").val();
			
			$.ajax({
				type : "POST",
				url : "idCheck.jd",
				data : {"userId" : userId},
				success : function (responseData) {
					
					var data = JSON.parse(responseData);
					
					if (data.val == "false") {
						
						$("input[name='userId']").val("");
						
						$("#idCheck").html(userId+"는 이미 사용 중인 아이디입니다.");
						$("#idCheck").addClass("red");
						
					} else {
						
						$("#idCheck").html("사용 가능한 아이디입니다.");
						$("#idCheck").removeClass("red");
						
					}
					
				},
				error : function (e) {
					
					alert(e.responseText);
					
				}
			});
			
		});
		
		$("input[name='userEmailId'], select[name='userEmailAddress']").change(function () {
			
			var userEmail = $("input[name='userEmailId']").val()+"@"+$("select[name='userEmailAddress']").val();
			
			$.ajax({
				type : "POST",
				url : "emailCheck.jd",
				data : {"userEmail" : userEmail},
				success : function (responseData) {
					
					var data = JSON.parse(responseData);
					
					if (data.val == "false") {
						
						$("input[name='userEmailId']").val("");
						
						$("#emailCheck").html("이미 사용 중인 이메일입니다.");
						$("#emailCheck").addClass("red");
						
					} else {
						
						$("#emailCheck").html("사용 가능한 이메일입니다.");
						$("#emailCheck").removeClass("red");
						
					}
					
				},
				error : function (e) {
					
					alert(e.responseText);
					
				}
			});
			
		});
		
		$("input[type='submit']").click(function () {
			
			var userId = $("input[name='userId']").val();
			var userPw = $("input[name='userPw']").val();
			var userPwCheck = $("input[name='userPwCheck']").val();
			var userEmailId = $("input[name='userEmailId']").val();
			var userType = $("input[name='userType']:checked").val();
			
			if (userId.length == 0) {
				
				$("#warningResult").html("<h1 class='red'>아이디를 입력하시오.</h1>");
				$("#warningPopUp").css("display", "block");
				
				$("input[name='userId']").val("");
				
				return false;
				
			}
			
			var trimUserId = userId.trim().replace(/\s/g,"");
			
			if (userId != trimUserId) {
				
				$("#warningResult").html("<h1 class='red'>아이디에 공백이 포함되어 있습니다.</h1>");
				$("#warningPopUp").css("display", "block");
				
				$("input[name='userId']").val("");
				
				return false;
				
			}
			
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
			
			if (userEmailId.length == 0) {
				
				$("#warningResult").html("<h1 class='red'>이메일을 입력하시오</h1>");
				$("#warningPopUp").css("display", "block");
				
				return false;
				
			}
			
			var trimUserEmailId = userEmailId.trim().replace(/\s/g,"");
			
			if (userEmailId != trimUserEmailId) {
				
				$("#warningResult").html("<h1 class='red'>이메일 주소의 공백을 확인하세요</h1>");
				$("#warningPopUp").css("display", "block");
				
				$("input[name='userEmailId']").val("");
				
				return false;
				
			}
			
			if (typeof userType == "undefined") {
				
				$("#warningResult").html("<h1 class='red'>USER TYPE을 입력하시오</h1>");
				$("#warningPopUp").css("display", "block");
				
				return false;
				
			}
			
			return true;
			
		});
		
	});
</script>
</head>
<body>
	<div class="w3-card-4" id="container">
		<header class="w3-container w3-teal"><h1>SIGN UP</h1></header>
		<div class="w3-container w3-margin">
			<form action="join.jd" method="post">
				<table class="w3-table">
					<col width="20%"/>
					<col width="80%"/>
					<tr>
						<th>ID</th>
						<td>
							<input type="text" name="userId" size="20" />
							<span id="idCheck"></span>
						</td>
					</tr>
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
						<th>EMAIL</th>
						<td>
							<input type="text" name="userEmailId" />
							@
							<select name="userEmailAddress">
								<option value="gmail.com">gmail.com</option>
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
							</select>
							<span id="emailCheck"></span>
						</td>
					</tr>
					<tr>
					
						<td colspan="2">
							<input class="w3-radio" type="radio" name="userType" value="CUS" /> CUSTOMER
							<input class="w3-radio" type="radio" name="userType" value="VEN" /> VENDOR
							<input class="w3-radio" type="radio" name="userType" value="FAC" /> FACTORY
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="w3-right-align">
								<input type="submit" value="SIGN UP" />
								<a href="/jungduck92/" style="text-decoration: none;">
									<input type="button" onclick="javascript:void(0)" value="CANCLE" />
								</a>
							</div>
						</td>
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