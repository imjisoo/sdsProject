<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FACTORY 상품 등록 결과 페이지</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/main.css">
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

button {
	background: url(img/heart.png) no-repeat center;
	background-size: contain;
}

.btn-right{float:right;}
</style>

</head>
<body>

	<div class="w3-card-4" id="container">
		<header class="w3-container w3-teal">
		<h2>상품 등록 결과</h2>
		<br>
		</header>
		<div class="w3-container w3-margin">
			<h3>상품 등록이 완료되었습니다.</h3> <br>
			<a href="fac_index.jd" class="w3-button w3-white w3-border w3-border-blue w3-round-xlarge btn-right">Factory 메인으로</a>
			<a href="productList.jd" class="w3-button w3-white w3-border w3-border-blue w3-round-xlarge btn-right">상품 리스트</a>
		</div>
		<footer class="w3-container w3-teal w3-right-align">
		<h5>@jungduck92</h5>
		</footer>
	</div>

</body>
</html>