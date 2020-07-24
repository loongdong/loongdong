<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>
<c:set var="sesInfo" value="${mInfo }" scope="session" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div id="br_menu" class="">
	<article id="wrap" class="br_menu_view">
		<div id="content">
			<div class="inner_content">
				<div class="view_wrap">
					<article
						class="view_product ${pvo.category == 'icecone' ? 'icecream':''}">
						<!-- 아이스크림일 경우 클래스 icecream -->
						<header class="header">
							<h2 class="name">
								<c:if test="${pvo.engpname ne ''}">
									<small>${pvo.engpname}</small>
								</c:if>
								${pvo.pname }
							</h2>
							<p class="content">${pvo.pcontent }</p>
							<%-- <p class="content">
                        <fmt:formatNumber value='${pvo.price }' type="number" />
                    </p> --%>
							<div class="photo">
								<img src="/images/${pvo.pimg }" alt="">
							</div>
							<div class="buy">
								<a href="/order/ocheck?pno=${pvo.pno }" target="_blank">구매하기</a>
							</div>
						</header>
						<!-- ###제품정보### -->
						<div class="prdinfo">
							<!-- SNS -->
							<div class="link">
								<p class="btn_store ">
									<a href="/store/map.php?storechk=y" target="_blank"><img
										src="/images/btn_store.gif" alt="판매 매장 확인"></a>
								</p>
								<div class="rig">
									<nav class="sns">
										<ul>
											<li class="favorite"><a
												href="/cart/add?pno=${pvo.pno }&mno=${sesInfo.mno}"
												data-api="favorite" data-seq="521"> <span>좋아하는
														플레이버 등록</span>
											</a></li>
											<li><a href="#none" role="button" data-sns="facebook">
													<img src="/images/icon_facebook.png" alt="FACEBOOK">
											</a></li>
											<li><a href="#none" role="button" data-sns="twitter">
													<img src="/images/icon_twitter.png" alt="TWITTER">
											</a></li>
											<li><a href="#none" role="button" data-sns="copyurl">
													<img src="/images/icon_copy.png" alt="copy">
											</a></li>
											<!-- 리뷰등록버튼추가 -->
											<li><a href="/review/add?pno=${pvo.pno }"> <img
													src="/images/icon_copy.png">리뷰등록
											</a></li>
										</ul>
									</nav>
								</div>
							</div>
							<!-- 아이스크림 -->
							<c:if test="${pvo.regd8 ne null}">
								<p class="date">
									<strong>출시일 </strong> ${pvo.regd8}
								</p>
							</c:if>
							<!-- 아이스크림 케이크 -->
							<c:if test="${pvo.category eq  'cake'}">
								<div class="material">
									<strong>아이스크림 </strong>
									<p>
										<c:forEach items="${meList }" var="pvo2" varStatus="i">
											<span>${pvo2.pname }</span>
											<c:if test="${!i.last}">,</c:if>
										</c:forEach>
									</p>
								</div>
							</c:if>
							<!-- 음료 -->
							<p class="bg_con">
								<img src="/images/img_con.png" alt="">
							</p>
						</div>
						<!-- //###제품정보### -->
					</article>

					<c:if test="${pvo.category eq  'coffee'}">
						<article class="view_coffee">
							<h2>배스킨라빈스 커피는 어떻게 만들어졌을까요?</h2>
							<div class="hot">
								<img src="/images/h_hot_coffee.jpg" alt="HOT COFFEE">
								<div id="slider-coffee-hot" class="coffee-list"
									data-option="container">
									<div class="list_wrap"
										style="width: 1435px; position: absolute; left: -422.65px;">
										<ul>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_1.jpg" alt="에스프레소">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_2.jpg" alt="아포가토">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_3.jpg" alt="아메리카노">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_4.jpg" alt="카페라떼">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_5.jpg" alt="카페모카">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_6.jpg" alt="카라멜 마끼아토">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_hot_coffee_list_7.jpg" alt="U라떼">
												</figure>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="ice">
								<img src="/images/h_ice_coffee.jpg" alt="ICE COFFEE">
								<div id="slider-coffee-ice" class="coffee-list"
									data-option="container">
									<div class="list_wrap"
										style="width: 1435px; position: absolute; left: -319.811px;">
										<ul>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_1.jpg"
														alt="아이스 아메리카노">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_2.jpg" alt="아이스 카페라떼">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_3.jpg" alt="아이스 카페모카">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_4.jpg"
														alt="아이스 카라멜 마끼아토">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_5.jpg" alt="핑크라떼">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_6.jpg" alt="아이스 U라떼">
												</figure>
											</li>
											<li class="wrap_li">
												<figure>
													<img src="/images/img_ice_coffee_list_7.jpg"
														alt="연유 크러쉬 라떼">
												</figure>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</article>
					</c:if>

					<c:if test="${pvo.category eq  'cake'}">
						<article class="view_flavor consist">
							<h2>어떤 맛이 들어있을까?</h2>
							<div class="list_product">
								<ul class="list">
									<c:forEach items="${meList }" var="pvo2">
										<li><input type="hidden" name="pno" value="${pvo2.pno }">
											<input type="hidden" name="pname" value="${pvo2.pname }">
											<input type="hidden" name="engpname"
											value="${pvo2.engpname }"> <input type="hidden"
											name="pcontent" value="${pvo2.pcontent }"> <input
											type="hidden" name="pimg" value="${pvo2.pimg}"> <a
											data-api="modal" href="#modal_consist" class="modal_detail"><span
												class="title">${pvo2.pname }</span><img
												src="/images/${pvo2.pimg }" alt=""></a></li>
									</c:forEach>
								</ul>
							</div>
						</article>
					</c:if>

					<c:if test="${pvo.category eq  'icecone'}">
						<article class="view_price">
							<section class="concup">
								<h2>
									<img src="/images/tit_concup.gif" alt="cone &amp; cup">
								</h2>
								<ul>
									<li class="c1"><span>싱글레귤러</span> 한가지 맛을 센스있게<br> 즐길수
										있는 사이즈<br> (용기무게 제외 중량 115g) <strong>3,200원</strong></li>
									<li class="c2"><span>싱글킹</span> 좋아하는 맛 한가지만 듬뿍 <br>
										맛볼 수 있는 사이즈 (중량 145g) <strong>4,000원</strong></li>
									<li class="c3"><span>더블주니어</span> 두가지 맛을 조금씩 한번에 <br>
										즐기는 사이즈 (중량 150g) <strong>4,300원</strong></li>
									<li class="c4"><span>더블레귤러</span> 아이스크림 매니아를 위한 <br>
										진정한 더블 사이즈 (중량 230g) <strong>6,200원</strong></li>
								</ul>
							</section>
							<section class="handpack">
								<h2>
									<img src="/images/tit_handpack.gif" alt="hand pack">
								</h2>
								<ul>
									<li class="p1"><span>파인트</span> 3가지 맛을 골라먹는 재미가 <br>
										있는 사이즈 (중량 320g) <strong>8,200원</strong></li>
									<li class="p2"><span>쿼터</span> 4가지 맛을 골라먹는 재미가<br> 있는
										사이즈 (중량 620g) <strong>15,500원</strong></li>
									<li class="p3"><span>패밀리</span> 5가지 맛을 나눠먹는 재미가<br>
										있는 사이즈 (중량 960g) <strong>22,000원</strong></li>
									<li class="p4"><span>하프갤런</span> 6가지 맛을 나눠먹는 재미가 <br>
										있는 사이즈 (중량 1200g) <strong>26,500원</strong></li>
								</ul>
							</section>
						</article>
						<c:if test="${pvo.recommend ne '' }">
							<article class="view_flavor consist">
								<div class="list_product">
									<ul class="list">
										<c:if test="${rcList.size() > 1}">
											<h2>추천플레이버</h2>
										</c:if>
										<c:forEach items="${rcList }" var="pvo">
											<c:if test="${pvo.pno ne param.pno}">
												<li><input type="hidden" name="pno" value="${pvo.pno }">
													<input type="hidden" name="pname" value="${pvo.pname }">
													<input type="hidden" name="engpname"
													value="${pvo.engpname }"> <input type="hidden"
													name="pcontent" value="${pvo.pcontent }"> <input
													type="hidden" name="pimg" value="${pvo.pimg}"> <a
													data-api="modal" href="#modal_consist" class="modal_detail">
														<!--  <a href="#modal_consist" data-api="modal" data-seq="134"> -->
														<span class="title">${pvo.pname }</span> <img
														src="/images/${pvo.pimg}" alt="">
												</a></li>
											</c:if>
										</c:forEach>
									</ul>
								</div>
								<div class="dslide">
									<!-- paging -->
								</div>
							</article>
						</c:if>
					</c:if>

					<!-- 여기에 리뷰 추가 -->
					<article class="view_detail_insta">
						<div class="insta_header">
							<h2>인스타그램에서 만나는</h2>
							<p>#민트초콜릿칩 #배스킨라빈스</p>
						</div>

						<article class="view_flavor consist">
							<div class="list_product">
								<ul class="list">
									<c:if test="${rvList.size() > 1}">
										<h2>리뷰~~~</h2>
									</c:if>
									<c:forEach items="${rvList }" var="rvo" varStatus="status">

										<li><input type="hidden" name="count"
											value="${status.count}"> <input type="hidden"
											name="r_size" value="${rvList.size() }"> <input
											type="hidden" name="rno" value="${rvo.rno }"> <input
											type="hidden" name="mimg" value="${rvo.mimg }"> <input
											type="hidden" name="mid" value="${rvo.mid }"> <input
											type="hidden" name="rimg" value="${rvo.rimg}"> <input
											type="hidden" name="r_title" value="${rvo.title }"> <input
											type="hidden" name="r_content" value="${rvo.content }">
											<input type="hidden" name="r_like" value="${rvo.likes }">
											<input type="hidden" name="r_date" value="${rvo.regd8}">
											<!-- <button data-toggle="modal" data-target="#rvModal" class="btn btn-outline-warning modBtn" >수정</button> -->
											<a data-api="modal" href="#rvmodal_consist"
											data-toggle="modal" data-target="#rvModal"
											class="rvmodal_detail"> <!--  <a href="#modal_consist" data-api="modal" data-seq="134"> -->
												<img id="rv_${status.count}"
												src="/images/review/${rvo.rimg}" alt=""
												style="position: absolute; top: 0; left: 55px; width: 100%; height: 100%">
										</a></li>
									</c:forEach>
								</ul>
							</div>
							<div class="dslide">
								<!-- paging -->
							</div>
						</article>
					</article>
				</div>

				<div class="store_delivery" style="display: none;">
					<!-- 2018-10-29 최하단 좌측 배너 Start  -->
					<section class="store">
						<!-- <h3 class="title"><img src="/images/h_store.png" alt="BR STORE"></h3> -->
						<div class="box">
							<a href="#"><img src="/images/img_store.jpg"
								alt="내 주변 가장 가까운 배스킨라빈스 매장을 찾아보세요! 다양한 즐거움과 새로움! 우리동네 배스킨라빈스! 매장찾기"></a>
						</div>
					</section>

					<!-- 2018-10-29 최하단 좌측 배너 End  -->
					<!-- 2018-10-29 최하단 우측 배너 Start  -->
					<section class="order">
						<!-- <h3 class="title"><img src="/images/h_happyorder_delivery.png" alt="HAPPY ORDER &amp; DELIVERY"></h3> -->
						<div class="box">
							<a href="/store/catering.php"><img
								src="/images/img_happyorder_delivery.png"
								alt="배스킨라빈스 모바일 사전주문 &amp; 배달서비스 - 해피오더 배달 콜센터 1670-3131 주문에서 결제 &amp; 배송까지 간단하게!"></a>
						</div>
					</section>
				</div>
				<div class="btn_list top55">
					<!-- 2018-10-26 Modify -->
					<a
						href="/product/category_list?category=${pvo.category }&pageNum=${cri.pageNum }&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword}">목록</a>
				</div>
			</div>
			<!--             <nav class="page_prevnext  icecream" style="top: 2342px;">
                <ul>
                    <li class="prev"><a href="view.php?seq=172">
                            <div>
                                <span class="image"> <img
                                    src="/upload/product/1530775244.png" alt="">
                                </span> <span class="title"> 바닐라 </span>
                            </div>
                    </a></li>
                    <li class="next"><a href="view.php?seq=80">
                            <div>
                                <span class="image"> <img
                                    src="/upload/product/1530778001.png" alt="">
                                </span> <span class="title"> 그린티 </span>
                            </div>
                    </a></li>
                </ul>
            </nav> -->
			<div class="event_delivery">
				<div class="inner">
					<div class="event">
						<h3>
							<img src="/images/tit_event.png" alt="진행중인 이벤트">
						</h3>
						<ul>
							<li><a href="/event/view.php?flag=&amp;seq=7162">펭수 우산
									쿼터[15,500원] 이상 구매 시 3,900원!</a></li>
							<li><a href="/event/view.php?flag=&amp;seq=7242">패밀리[22,000원]
									이상 구매시 펭수매트 3,900원!</a></li>
							<li><a href="/event/view.php?flag=&amp;seq=7182">KT 멤버십
									VIP 혜택 더블주니어 FREE!</a></li>
						</ul>
					</div>
					<div class="order">
						<h3>
							<img src="/images/tit_happy_order.png"
								alt="HAPPY ORDER &amp; DELIVERY">
						</h3>
						<p>
							<img src="/images/img_happy_order.png" alt="">
						</p>
						<p class="qr">
							<img src="/images/img_order_code.png" alt="">
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- 	<div class="container">
			<button id="addCart">카트추가 테스트</button>

		</div>

		<form action="">
			<input type="checkbox" name="cnos" value="13">카트13<br> <input
				type="checkbox" name="cnos" value="16">카트16<br> <input
				type="checkbox" name="cnos" value="12">카트12<br> <input
				type="checkbox" name="cnos" value="13">카트13<br> <input
				type="checkbox" name="cnos" value="14">카트14<br> <input
				type="checkbox" name="cnos" value="15">카트15<br> <br>
			<input type="button" onclick="delCart()" value="카트에서삭제">
		</form> -->
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</article>
	<div id="modal_consist" class="modal">
		<div class="modal_bg"></div>
		<div class="modal_container">
			<div class="modal_content">
				<div class="prd"></div>
				<div class="link">
					<nav class="sns">
						<ul>
							<li class="favorite"><a href="#none" data-api="favorite"
								data-seq="13"> <span>좋아하는 플레이버 등록</span>
							</a></li>
							<li><a href="#none" role="button" data-sns="facebook"> <img
									src="/images/icon_facebook.png" alt="FACEBOOK">
							</a></li>
							<li><a href="#none" role="button" data-sns="twitter"> <img
									src="/images/icon_twitter.png" alt="TWITTER">
							</a></li>
							<li><a href="#none" role="button" data-sns="copyurl"> <img
									src="/images/icon_copy.png" alt="copy">
							</a></li>
						</ul>
					</nav>
					<p class="buy">
						<!-- 구매하기 -->
					</p>
				</div>
			</div>
			<div class="modal_close">
				<a href="#none"> <img src="/images/btn_pop_close.png" alt="">
				</a>
			</div>
		</div>
	</div>

	<!-- The 리뷰 Modal -->
	<div class="modal" id="rvModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">


				<!-- Modal body -->
				<div class="modal-body">
					<div class="rv_total">
						<div class="rvLeft"></div>
						<div id="rv_member"></div>
						<div class="rv_clear"></div>
						<div id="rv_content"></div>
						<div class="rv_clear"></div>
						<div id="rv_footer">
							<div id="rv_hidden"></div>
							<ul class="nav nav-pills nav-justified">
								<li class="nav-item rv_prev"><div class="rv_control">
										<i style="font-size: 24px" class="fa rv_prev">&#xf104;</i>
									</div></li>
								<li class="nav-item" id="ilkenum"><i id="r_heart" class="fa fa-heart addlike" style="font-size:24px;"></i><span id=rlike></span></li>
								
								
								<li class="nav-item rv_next"><div class="rv_control">
										<i style="font-size: 24px" class="fa rv_next">&#xf105;</i>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- 	<!-- Modal footer -->
			<!-- 	<div class="modal-footer">
					<button type="button" id="modOkBtn" data-dismiss="modal"
						class="btn btn-primary">확인</button>
				</div> -->

		</div>
	</div>
</div>
<!-- order.css 추가 -->
<link href="/resources/css/review.css" rel="stylesheet">
<script src="/resources/js/cart.js"></script>
<script>
	$(function() {
		$(document).on("click", ".modal_detail", function() {
			$("#br_menu").attr('class', 'open_modal');
			//리뷰모달 클래스 삭제구문추가
			$("#rvModal").removeClass('modal');
			let parentsLi = $(this).closest("li");
			$(".modal").addClass('in');
			$(".modal").addClass('on');
			let pno = $(parentsLi).find("input[name=pno]").val();
			let pname = $(parentsLi).find("input[name=pname]").val();
			let engpname = $(parentsLi).find("input[name=engpname]").val();
			let pcontent = $(parentsLi).find("input[name=pcontent]").val();
			let pimg = $(parentsLi).find("input[name=pimg]").val();
			transferToModal(pno, engpname, pname, pcontent, pimg);
		});

		//리뷰디테일모달보기  
		$(document)
				.on(
						"click",
						".rvmodal_detail",
						function() {
							let parentsLi = $(this).closest("li");
							let mid = $(parentsLi).find("input[name=mid]")
									.val();
							let mimg = $(parentsLi).find("input[name=mimg]")
									.val();
							let rimg = $(parentsLi).find("input[name=rimg]")
									.val();
							let r_title = $(parentsLi).find(
									"input[name=r_title]").val();
							let r_content = $(parentsLi).find(
									"input[name=r_content]").val();
							let r_regd8 = $(parentsLi).find(
									"input[name=r_date]").val();
							let r_count = $(parentsLi)
									.find("input[name=count]").val();
							let r_size = $(parentsLi)
									.find("input[name=r_size]").val();
							let rno = $(parentsLi).find("input[name=rno]")
									.val();
							let r_like = $(parentsLi)
									.find("input[name=r_like]").val();
							transferToRvModal(mid, mimg, rimg, r_title,
									r_content, r_regd8, r_count, r_size, rno,
									r_like);
						})

		function transferToModal(pno, engpname, pname, pcontent, pimg) {
			let content = '<div class="photo"> <img src="/images/'+pimg+'"></div><h2 class="name"> <small>'
					+ engpname
					+ '</small>'
					+ pname
					+ '</h2><p class="content">'
					+ pcontent
					+ '</p><p class="linkview">  <a href="/product/detail?pno='
					+ pno + '"><img src="/images/btn_goview.gif"></a></p>';
			$(document).find(".modal_content .prd").html(content);
		}
		$(document).on("click", ".modal_close", function() {
			$(".modal").removeClass('in on');
			$("#br_menu").attr('class', '');
			$("#rvModal").attr('class', 'modal');
		});
	});
</script>