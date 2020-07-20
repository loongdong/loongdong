<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">

	<div class="dropdown">
		<div>
			<button class="dropbtn">Flavor of Month</button>
			<button class="dropbtn">MENU</button>
			<button class="dropbtn">EVENT</button>
			<button class="dropbtn">STORE</button>
			<button class="dropbtn">ABOUT</button>
		</div>
		<div class="dropdown-content">
			<ul>
				<li><a href="#">카트 필요한것 mno pno</a></li>
				<li><a href="/order/ocheck">주문 폼태그로 이동</a></li>
				<li><a href="/cart/test?price=5">String자르기테스트</a></li>
				<li><a href="/cart/add?mno=1">카트추가 테스트</a></li>
				<li><a href="/product/cart">카트목록으로가기</a></li>
			</ul>

			<ul>
				<li><a href="/order/list">구매내역/선물내역 확인 페이지</a></li>
				<li><a href="#">Link 5</a></li>
				<li><a href="#">Link 6</a></li>
			</ul>

			<ul>
				<li><a href="#">Link 7</a></li>
				<li><a href="#">Link 8</a></li>
				<li><a href="#">Link 9</a></li>
			</ul>
			<ul>
        <li><a href="#">Link 10</a></li>
        <li><a href="#">Link 11</a></li>
        <li><a href="#">Link 12</a></li>
      </ul>
      <ul>
        <li><a href="#">Link 13</a></li>
        <li><a href="#">Link 14</a></li>
        <li><a href="#">Link 15</a></li>
      </ul>
		</div>

	</div>
</nav>
