<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="sesInfo" value="${mInfo }" scope="session" />

<link href="/resources/css/cart.css" rel="stylesheet">

<div class="container">
	<h1>장바구니</h1>
	<p>
		<span id="count">0개</span> 상품
	</p>
	<hr>
	<hr>
	<form name=cartForm action="">
		<table class="table table-hover" id="cartList">
			<thead>
				<tr>
					<th><input type="checkbox" name="checkAll" id="checkAll"
						onclick="chkAll()"></th>
					<th colspan="2">상품</th>
					<th>가격(원)</th>
					<th>구매시적립포인트</th>
					<th>구매하기</th>
				</tr>
			</thead>
		</table>
	</form>

	<input type="button" onclick="delCart()" value="카트에서삭제"> <input
		type="button" onclick="ordFromCart()" value="선택상품주문">
	<div id="cartPaging"></div>
	<form id="goOrder" action="/order/ocheck" method="post">
		<input type="hidden" id="prePno" name="pno" class="" value="">
		<input type="hidden" id="preCno" name="cno" class="" value="">
	</form>
</div>


<script src="/resources/js/cart.js"></script>
<script src="/resources/js/order.js"></script>
<script>
	//mno 세션에서 가져오기
	let mno = '<c:out value="${sesInfo.mno }"/>'
	listCart(mno, 1);
	$(document).on("click", "#cartPaging li a", function(e) {
		e.preventDefault();
		listCart(mno, $(this).attr("href"));
	});
</script>
