<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
button {
	background: url(img/heart.png) no-repeat center;
	background-size: contain;
}
</style>
</head>
<body>
	<div class="w3-card-4" id="container">
		<header class="w3-container w3-teal"><h1>WELCOME TO FACTORY</h1></header>
		<div class="w3-container w3-margin">
			<table class="w3-table w3-centered">
				<tr>
					<td>
						<form action="orderConfirm.jd" method="post"><button class="w3-button">주문 확인</button></form>
					</td>
					<td>
						<form action="stockConfirm.jd" method="post"><button class="w3-button">재고확인</button></form>
					</td>
					<td>
						<form action="productRegi.jd" method="post"><button class="w3-button">상품등록</button></form>
					</td>
				</tr>
			</table>
		</div>
		<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
	</div>
</body>
</html>