
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="sesInfo" value="${mInfo }" scope="session" />
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<link href="/resources/css/order.css" rel="stylesheet">
<div class="container">
	<div class="topbox">
		<h1>해피콘 주문/결제</h1>
	</div>
	<hr>
	<h3>주문상품정보</h3>
	<hr>
	<table class="table table-hover" id="preorderList">
		<thead>
			<tr>
				<th>번호</th>
				<th colspan="2">상품</th>
				<th>가격(원)</th>
				<th>수량</th>
				<th>사이즈(아이스크림)</th>
			</tr>
		</thead>
	</table>
	<form id="orderForm" action="/order/add" method="post">
		<div class="orderDetail">
			<h3>가격정보</h3>
			<hr>
			<h5>
				총 가격 : <input id="total" name="total" readonly="readonly">
			</h5>
			<h5>
				구매 시 적립포인트 : <input id="mpoint" name="mpoint" readonly="readonly">
			</h5>
			<hr>
		</div>
		<div class="orderDetail">
			<h3>선물하는 분 정보</h3>

			<p>선물하는 분</p>
			<input type="text" size="5" value="${sesInfo.mname }"
				readonly="readonly">

			<p>휴대폰 번호</p>
			<input size="10" name="phone" type="text" value="${sesInfo.phone }"
				readonly="readonly">

		</div>
		<div class="orderDetail">

			<p>선물받는분 정보 입력</p>

			<p>받는분ID</p>
			<input size="5" type="text" name="receiver_id">


			<h5>메시지 입력</h5>

			<input type="text" name="memo" <textarea cols="" rows=""/>>
		</div>
		<input type="hidden" id="orderpname" name="pname" value=""> <input
			type="hidden" id="orderamount" name="amount" value=""> 
			<input type="hidden" id="ordermno" name="mno" value="${sesInfo.mno }">
		<input type="hidden" id="ordercno" name="cno" value="${cno }">
		<button type="button" onclick="addOrder()" class="btn btn-primary">구매하기</button>
	</form>
</div>
<script src="/resources/js/order.js"></script>
<script>
	let total = 0;
	//mno 세션에서 가져오기
	let mno = '<c:out value="${sesInfo.mno }"/>'
	let pno = '<c:out value="${pno}"/>'
	let cno = '<c:out value="${cno}"/>'
	console.log("mno1 : "+ mno);
	console.log("pno : " + pno);
	console.log("cno : " + cno);
	preOrderGet(pno);
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>