
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container">
	<h1>해피콘 주문/결제</h1>
	<h3>주문상품정보</h3>

	<hr>
	<table class="table table-hover" id="preorderList">
		<thead>
			<tr>
				<th colspan="2">상품</th>
				<th>가격(원)</th>
				<th>사이즈(아이스크림)</th>
			</tr>
		</thead>
	</table>
	<form name=orderForm action="">
	<h3>
	총 가격 : <input id="total" name="total" readonly="readonly">
	</h3>
	<h3>
    구매 시 적립포인트 : <input id="mpoint" name="mpoint" readonly="readonly">
  </h3>
	<hr>
		<h3>선물정보 입력</h3>
		<h5>선물하는 분 정보</h5>
		<hr>
		<table>
			<tr>
				<th>선물하는 분</th>
				<th><input type="text" value="멤버테이블 id" readonly="readonly"></th>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<th><input name="phone" type="text" value="멤버테이블  번호"
					readonly="readonly"></th>
			</tr>
		</table>
		<hr>
		<h5>선물받는 분 정보</h5>

		<table>
			<tr>
				<th>받는분ID</th>
				<th><input type="text" name="receiver_id"></th>
			</tr>
		</table>
		<hr>
		<h5>메시지 입력</h5>
		<table>
			<tr>
				<th>메시지</th>
				<th><textarea cols="" rows=""></textarea></th>
			</tr>
		</table>


	</form>
	<button>구매하기</button>
</div>
<script src="/resources/js/order.js"></script>
<script>
	let total = 0;
	//mno 세션에서 가져오기
	let mno = 1;
	//pno는 카트페이지에서 받아오기
	let pno = '<c:out value="${pno}"/>'
	let cno = '<c:out value="${cno}"/>'
	console.log("pno : " + pno);
	console.log("cno : " + cno);
	preOrderGet(pno);
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>