<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
	td{text-align: center;}
	img{height:100px;width:100px}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$('#btn_prdRegi').on('click',function(){
			location.href="productRegi.jd";
		});
		
		$('#btn_main').on('click',function(){
			location.href="fac_index.jd";
		});
		
		$('.btn_update').on('click',function(){
			location.href="productUpdate.jd?idx="+$(this).attr('data-idx');
		});
		
		var $imgUrl, imgSrc;
		
		/* $('.img_url').each(function(){
			$imgUrl= $(this).text();
			imgSrc = "/image/" + $imgUrl + ".jpg";
			$('.img_url').siblings('img').attr('src', imgSrc);
		});
		 */
		
	})
</script>
</head>
<body>
	<div class="w3-card-4" id="container">
		<header class="w3-container w3-teal">
			<h2>상품 리스트</h2> <br>
		</header>
		<div class="w3-container w3-margin">
			<table class="w3-table w3-striped">
				<tr>
					<th>No.</th>
					<th>상품명</th>
					<th>상품 이미지</th>
					<th>상품 썸네일 이미지</th>
					<th>상품 공급가</th>
					<th>상품 원가</th>
					<th>상품 수량</th>
					<th>등록일자</th>
					<th>상품 상태</th>
					<th>비고</th>
				</tr>
				<c:if test="${empty product_list}">
					<tr>
						<td colspan="10">
							등록된 상품이 존재하지 않습니다
						</td>
					</tr>
				</c:if>
				<c:if test="${not empty product_list }">
					<%
						int rowNum = 1;
					%>
					<c:forEach items="${product_list}" var="p">
						<tr>
							<td><%=rowNum++ %></td>
							<td>${p.prdName}</td>
							<td><img src="/image/Koala.jpg"><span class="img_url">${p.prdImg }</span></td>
							<td><img src="/image/Koala.jpg"><span class="img_url">${p.prdThumb}</span></td>
							<td>${p.prdPrice}</td>
							<td>${p.prdCost }</td>
							<td>${p.prdQty}</td>
							<td>${p.inputDate}</td>
							<td>${p.prdUseYn }</td>
							<td>
								<input type="button" value="수정" class="btn_update" data-idx="${p.prdIdx }" />
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="8"></td>
					<td colspan="2">
						<button id="btn_prdRegi">등록</button>
						<button id="btn_main">메인으로</button>
					</td>
				</tr>
			</table>
		</div>
		
		<footer class="w3-container w3-teal w3-right-align">
			<h5>@jungduck92</h5>
		</footer>
	</div>
</body>
</html>