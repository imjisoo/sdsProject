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
</head>
<body>
	<div class="w3-container" id="container">
		<header class="w3-container w3-teal"><h1>상품 등록</h1></header>
		<div class="w3-container w3-margin">
			<form action="productResult.jd" enctype="multipart/form-data" method="post">
				<input type="hidden" name="prdIdx" value="aa" />
				<input type="hidden" name="inputId" value="aa" />
				<input type="hidden" name="inputDate" value="aa" />
				<table class="w3-table">
					<col width="20%"/>
					<col width="80%"/>
					<tr>
						<th>PRD_NAME</th>
						<td><input type="text" name="prdName" class="w3-animate-input"></td>
					</tr>
					<tr>
						<th>PRD_IMG</th>
						<td><input type="file" name="prdImgFile"></td>
					</tr>
					<tr>
						<th>PRD_THUMB</th>
						<td><input type="file" name="prdThumbFile"></td>
					</tr>
					<tr>
						<th>PRD_PRICE</th>
						<td><input type="text" name="prdPrice" class="w3-animate-input"></td>
					</tr>
					<tr>
						<th>PRD_COST</th>
						<td><input type="text" name="prdCost" class="w3-animate-input"></td>
					</tr>
					<tr>
						<th>PRD_QTY</th>
						<td><input type="text" name="prdQty" class="w3-animate-input"></td>
					</tr>
					<tr>
						<th>PRD_USEYN</th>
						<td>
							<input class="w3-radio" type="radio" name="prdUseYn" value="Y"><label>....ING</label>
							<input class="w3-radio" type="radio" name="prdUseYn" value="N"><label>....NOPE!</label>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="w3-right-align">
							<input type="submit" value="등록">
							<a href="fac_index.jd" style="text-decoration: none;">
								<input type="button" onclick="javascript:void(0)" value="취소" />
							</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<footer class="w3-container w3-teal w3-right-align"><h5>@jungduck92</h5></footer>
	</div>
</body>
</html>