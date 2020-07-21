<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="sesInfo" value="${mInfo }" scope="session" />

<link href="/resources/css/baskin.css" rel="stylesheet">

<!-- Navigation -->
<header id="header">
  <div class="inner_header">
    <div class="top_area">
      <div class="inner">
        <h1 class="logo">
          <a href="/"><img src="/resources/img/icon_baskin.png"
            alt="FACEBOOK"> </a>
        </h1>

        <nav class="sns">
          <ul>
            <li><a href="https://www.facebook.com/baskinrobbins.kr/"
              target="_blank"> <img src="/resources/img/icon_fb.png"
                alt="FACEBOOK">
            </a></li>
            <li><a href="https://twitter.com/BaskinrobbinsKR"
              target="_blank"> <img src="/resources/img/icon_tw.png"
                alt="TWITTER">
            </a></li>
            <li><a href="http://blog.naver.com/brgirl31" target="_blank">
                <img src="/resources/img/icon_blog.png" alt="BLOG">
            </a></li>
            <li><a href="https://www.instagram.com/baskinrobbinskorea/"
              target="_blank"> <img src="/resources/img/icon_is.png"
                alt="INSTAGRAM">
            </a></li>
            <li><a href="https://www.youtube.com/user/baskinrobbinskorea"
              target="_blank"> <img src="/resources/img/icon_yt.png"
                alt="YOUTUBE">
            </a></li>
          </ul>
        </nav>

        <nav class="etc">
          <ul>
            <li class="customer"><a href="/customer/ccm.php">고객센터</a></li>
            <li class=""><a href="/menu/nutrition_new.php">영양정보</a></li>
            <li><a href="/about/contact_us.php">CONTACT US</a></li>
            <li class="search"><a href="#modal_search" data-api="modal"><img src="/resources/img/icon_sc.png"
                alt="SEARCH"></a>
            </li>
          </ul>
        </nav>
      </div>
    </div>

    <div class="menu_area">
      <div class="inner">
      <nav class="member">
            <c:if test="${sesInfo eq null }">  
              <ul>
               <li class="login">
                  <a href="/member/login">
                  <span><img src="../resources/img/login.png" alt="LOGIN"></span></a>
               </li>
               <li class="join">
                  <a href="/member/join"><span><img src="../resources/img/join.png" alt="JOIN"></span></a>
               </li>
              </ul>
            </c:if>
            <c:if test="${sesInfo ne null && sesInfo.mid ne null}">
              <ul>
                <li class="logout"><a href="/member/logout"><img src="/resources/img/icon_logout.png" alt="LOGOUT"></a></li>
                <li class="my-page"><a href="/member/mypage"><img src="/resources/img/icon_my.png" alt="MYPAGE"></a></li>
                </ul>
              </c:if>          
          </nav>
            
        <nav id="gnb">
          <div class="gnb_wrap">
            <ul>
              <li class="gnb_depth1 gnb_flavor">
                <div class="gnb_main">
                  <a href="/menu/fom.php"> <span><img src="../resources/img/fv_month.png"
                alt="FLAVOR"></span>
                  </a>
                </div>
                <div class="gnb_sub">
                  <!-- 이달의 플레이버 배너! -->
                  <a href="/menu/fom.php"><img
                    src="/assets/images/common/flavor/img_monthly_fom.jpg" alt=""></a>
                </div>
              </li>
              <li class="gnb_depth1 gnb_menu">
                <div class="gnb_main">
                  <a href="/product/list"> <span><img src="/resources/img/icon_menu.png"
                alt="MENU"></span>
                  </a>
                </div>
                <ul class="gnb_sub">
                  <li class="gnb_depth2"><a href="/product/category_list?category=icecone">
                      <span>아이스크림</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/product/category_list?category=cake">
                      <span>아이스크림케이크</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/product/category_list?category=drink">
                      <span>음료</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/product/category_list?category=coffee">
                      <span>커피</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/product/category_list?category=dessert">
                      <span>디저트</span>
                  </a></li>
                </ul>
              </li>
              <li class="gnb_depth1 gnb_event">
                <div class="gnb_main">
                  <a href="/event/list.php"> <span><img src="../resources/img/icon_event.png"
                alt="EVENT"></span>
                  </a>
                </div>
                <ul class="gnb_sub">
                  <li class="gnb_depth2"><a href="/event/list.php"> <span>진행중이벤트</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/event/winner.php"> <span>당첨자발표</span>
                  </a></li>
                  <li><a href="#">카트 필요한것 mno pno</a></li>
                  <li><a href="/order/ocheck">주문 폼태그로 이동</a></li>
                  <li><a href="/cart/test?price=5">String자르기테스트</a></li>
                  <li><a href="/cart/add?mno=1">카트추가 테스트</a></li>
                  <li><a href="/product/cart">카트목록으로가기</a></li>
                </ul>
              </li>
              <li class="gnb_depth1 gnb_store">
                <div class="gnb_main">
                  <a href="/store/map.php"> <span><img src="../resources/img/icon_store.png"
                alt="STORE"></span>
                  </a>
                </div>
                <ul class="gnb_sub">
                  <li class="gnb_depth2"><a href="/store/map.php"> <span>매장찾기</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/customer/ccm.php"> <span>고객센터</span>
                  </a></li>
                </ul>
              </li>
              <li class="gnb_depth1 gnb_about">
                <div class="gnb_main">
                  <a href="/about/notice_list.php"> <span><img src="/resources/img/icon_about.png"
                alt="ABOUT"></span>
                  </a>
                </div>
                <ul class="gnb_sub">
                  <li class="gnb_depth2"><a href="/about/notice_list.php">
                      <span>공지사항</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/about/press_list.php">
                      <span>보도자료</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/about/jobs.php"> <span>채용정보</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/about/br_system.php">
                      <span>점포개설문의</span>
                  </a></li>
                  <li class="gnb_depth2"><a href="/about/contact_us.php">
                      <span>Contact Us</span>
                  </a></li>
                </ul>
              </li>
            </ul>
          </div>
          <div class="gnb_bg">
            <div></div>
          </div>
        </nav>
      </div>
    </div>

  </div>
  <div id="modal_search" class="modal">
    <div class="modal_bg"></div>
    <div class="modal_container">
      <div class="modal_content">
        <div class="modal_header sr_only">
          <h2 class="title">제품 검색</h2>
        </div>
        <div class="modal_body">
          <div class="search_product">
            <form name="searchform" method="get" action="/search/result.php">
              <fieldset>
                <legend>제품 검색 폼</legend>
                <table class="table">
                  <caption>제품 검색 폼</caption>
                  <colgroup>
                    <col width="90">
                    <col width="486">
                    <col width="90">
                    <col width="*">
                  </colgroup>
                  <tr>
                    <th>제품명</th>
                    <td><select name="ScTop" class="search_category_1 inline">
                        <option value="">전체</option>
                        <option value="A">아이스크림</option>
                        <option value="B">아이스크림케이크</option>
                        <option value="C">음료</option>
                        <option value="D">커피</option>
                        <option value="E">디저트</option>
                    </select> <label class="sr_only" for="S-Title">제품명 입력</label> <input
                      type="text" id="S-Title" name="ScTitle" value=""
                      title="제품명 입력" class="inline"></td>
                    <th>해시태그</th>
                    <td>
                      <div>
                        <label class="sr_only" for="S-Hashtag">검색</label> <input
                          type="text" id="S-Hashtag" name="ScHashtag" value=""
                          class="my-placeholder inline" placeholder="">
                      </div>
                      <div class="hashtag">
                        <dl>
                          <dt>자주 찾는 해시태그</dt>
                          <dd>
                            <a href="#">#펭수아슈크림</a> <a href="#">#우주탐험펭수</a> <a
                              href="#">#펭수아슈크림블라스트</a>
                          </dd>
                        </dl>
                      </div>

                    </td>
                  </tr>
                  <tr>
                  </tr>
                  <tr>
                    <th>알레르기 성분</th>
                    <td colspan="3">
                      <div class="allergie">
                        <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="계란"> <span>계란</span>
                        </label> <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="대두"> <span>대두</span>
                        </label> <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="돼지고기"> <span>돼지고기</span>
                        </label> <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="땅콩"> <span>땅콩</span>
                        </label> <label class="clear_label"> <input class="sr_only"
                          type="checkbox" name="Allergy[]" value="밀"> <span>밀</span>
                        </label> <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="복숭아"> <span>복숭아</span>
                        </label> <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="우유"> <span>우유</span>
                        </label> <label> <input class="sr_only" type="checkbox"
                          name="Allergy[]" value="없음"> <span>없음</span>
                        </label>
                      </div>
                    </td>
                  </tr>
                </table>
                <div class="submit">
                  <button type="submit">검색</button>
                </div>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="modal_close">
      <a href="#none"> <img
        src="/assets/images/common/btn_search_close.gif" alt="">
      </a>
    </div>
  </div>

</header>