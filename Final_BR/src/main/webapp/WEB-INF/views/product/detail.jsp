<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<div class="container">
	<button id="addCart">카트추가 테스트</button>
	
</div>

<form action="">
	<input type="checkbox" name="cnos" value="13">카트13<br>
	<input type="checkbox" name="cnos" value="16">카트16<br>
	<input type="checkbox" name="cnos" value="12">카트12<br>
	<input type="checkbox" name="cnos" value="13">카트13<br>
	<input type="checkbox" name="cnos" value="14">카트14<br>
	<input type="checkbox" name="cnos" value="15">카트15<br>
	<br> <input type="button" onclick="delCart()" value="카트에서삭제">
</form>
<script src="/resources/js/cart.js"></script>
<script>

</script>
<jsp:include page="../common/footer.jsp"></jsp:include>