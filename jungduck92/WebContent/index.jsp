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
	width: 500px;
	margin: auto;
	margin-top: 15%;
}
span:HOVER {
	text-decoration: underline;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="w3-card-4" id="container">
		<header class="w3-container w3-teal"><h1>WELCOME</h1></header>
		<div class="w3-container w3-margin">
			<form action="login.jd" method="post">
				<table class="w3-table">
					<tr>
						<th>ID</th>
						<td><input type="text" name="userId" /></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" name="userPw" /></td>
					</tr>
				</table>
				<div>
					<div class="w3-third">
						<input type="submit" value="LOGIN" />
						<a href="joinForm.jd" style="text-decoration: none;">
							<input type="button" onclick="javascript:void(0)" value="JOIN" />
						</a>
					</div>
					<div class="w3-twothird w3-right-align">
						<a href="findForm.jd" style="text-decoration: none;"><span>forget your ID or PW?</span></a>
					</div>
				</div>
			</form>
		</div>
		<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
		<c:if test="${not empty loginStatement }">
			<div id="warningPopUp" class="w3-modal" style="display: block;">
				<div class="w3-modal-content">
					<header class="w3-container w3-teal"> 
						<span onclick="document.getElementById('warningPopUp').style.display='none'" class="w3-button w3-display-topright">&times;</span>
						<h2>WARNING</h2>
					</header>
					<div class="w3-container" id="warningResult">
						${loginStatement }
					</div>
					<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>