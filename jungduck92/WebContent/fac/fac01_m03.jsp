<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 수정</title>
</head>
<body>
	<div class="w3-container" id="container">
		<header class="w3-container w3-teal"><h1>상품 등록</h1></header>
		<div class="w3-container w3-margin">
			<form action="productResult.jd" enctype="multipart/form-data" method="post">
				<input type="hidden" name="prdIdx" value="${product.prdIdx }" />
				<input type="hidden" name="inputId" value="aa" />
				<input type="hidden" name="inputDate" value="aa" />
				<table class="w3-table">
					<col width="20%"/>
					<col width="80%"/>
					<tr>
						<th>PRD_NAME</th>
						<td><input type="text" name="prdName" class="w3-animate-input" value="${product.prdName }"></td>
					</tr>
					<tr>
						<th>PRD_IMG</th>
						<td><input type="file" name="prdImgFile" value="${product.prdImg }"></td>
					</tr>
					<tr>
						<th>PRD_THUMB</th>
						<td><input type="file" name="prdThumbFile" value="${product.prdThumb }"></td>
					</tr>
					<tr>
						<th>PRD_PRICE</th>
						<td><input type="text" name="prdPrice" class="w3-animate-input" value="${product.prdPrice }"></td>
					</tr>
					<tr>
						<th>PRD_COST</th>
						<td><input type="text" name="prdCost" class="w3-animate-input" value="${product.prdCost }"></td>
					</tr>
					<tr>
						<th>PRD_QTY</th>
						<td><input type="text" name="prdQty" class="w3-animate-input" value="${product.prdQty }"></td>
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
							<input type="submit" value="등록" id="pro_regi_submit">
							<a href="fac_index.jd" style="text-decoration: none;">
								<input type="button" onclick="javascript:cancel();" value="취소" />
							</a>
						</td>
					</tr>
				</table>
			</form>
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
</body>
</html>