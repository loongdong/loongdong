<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />

<!-- footer -->
<footer id="footer">
  <div class="inner_footer">
    <nav class="policy">
      <ul>
        <li style="width: 12%;"><a href="/about/br_system.jsp">
            점포개설문의 </a></li>
        <li style="width: 12%;"><a href="/about/jobs.jsp"> 채용문의 </a></li>
        <li style="width: 12%;"><a
          href="http://www.spc.co.kr/spc/smile/group/GEM_info.spc"
          target="_blank">윤리신고센터</a></li>
        <li style="width: 12%;"><a
          href="http://www.happypointcard.com/serviceCenter/term1.spc"
          target="_blank"> 이용약관 </a></li>
        <li class="privacy" style="width: 15%;"><a href="#">
            개인정보처리방침 </a></li>
        <li style="width: 20%;"><a href="#"> 영상정보처리기기운영관리방침 </a></li>
        <li style="width: 17%;"><a href="#" target="_blank"> 거래희망회사
            사전등록 </a></li>
      </ul>
    </nav>

    <div class="brand_family">
      <div class="inner">
        <nav class="brand">
          <ul>
            <li class="li_1"><a href="http://www.happypointcard.com"
              target="_blank"> <img
                src="/resources/img/btn_happypoint.png" alt="HAPPY POINT">
            </a></li>
            <li class="li_2"><a href="http://m.celectory.com"
              target="_blank"> <img
                src="/resources/img/btn_happymarket.gif" alt="HAPPY MARKET">
            </a></li>
            <li class="li_3"><a
              href="http://www.spc.co.kr/contributionAll" target="_blank">
                <img src="/resources/img/btn_spc_story.png"
                alt="SPC그룹 사회공헌활동 SPC 행복한 이야기">
            </a></li>
            <li class="li_4"><a
              href="https://sealinfo.verisign.com/splash?form_file=fdf/splash.fdf&dn=WWW.BASKINROBBINS.CO.KR&lang=ko"
              target="_blank"> <img src="/resources/img/btn_norton.gif"
                alt="Norton SECURED">
            </a></li>
            <li class="li_5"><a href="http://www.kca.go.kr/ccm/"
              target="_blank"> <img src="/resources/img/btn_ccm.gif"
                alt="소비자중심경영 인증제도">
            </a></li>
            <li><a href="http://knqa.ksa.or.kr/knqa/2276/subview.do"
              target="_blank"> <img src="/resources/img/btn_ksa.png"
                alt="국가품질상 - KSA 한국표준협회">
            </a></li>
          </ul>
        </nav>

        <nav class="familysite">
          <button type="button" class="" id="footer_btn">FAMILY SITE</button>
          <ul>
            <li><a href="http://www.baskinschool.co.kr/" target="_blank">배스킨
                스쿨</a></li>
            <li><a href="http://www.spc.co.kr/" target="_blank">SPC그룹사이트</a></li>
            <li><a href="http://www.spcmagazine.com/" target="_blank">SPC
                MAGAZINE</a></li>
            <li><a href="http://www.brkorea.co.kr/" target="_blank">BR코리아</a></li>
            <li><a href="http://www.happypointcard.com" target="_blank">해피포인트카드</a></li>
            <li><a href="http://www.caffe-pascucci.co.kr/"
              target="_blank">파스쿠찌</a></li>
            <li><a href="http://www.spcsamlip.co.kr/" target="_blank">삼립</a></li>
            <li><a href="http://www.paris.co.kr/" target="_blank">파리바게트</a></li>
            <li><a href="http://www.dunkindonuts.co.kr/" target="_blank">던킨도너츠</a></li>
          </ul>
        </nav>
      </div>
    </div>

    <div class="info">
      <h1 class="logo">
        <img src="/resources/img/footer_logo.png" alt="baskin robbins">
      </h1>
      <div class="box_1">
        <p>사업자 등록번호 : 303-81-09535</p>
        <p>비알코리아(주) 대표이사 김창대</p>
        <address class="address">서울특별시 서초구 남부순환로 2620(양재동
          11-149번지)</address>
      </div>
      <div class="box_2">
        <p>TEL : 080-555-3131</p>
        <p>개인정보관리책임자 : 김경우</p>
        <!-- <p>전자우편주소 : <a href="mailto:mun@spc.co.kr">mun@spc.co.kr</a></p> -->
      </div>
      <p class="copyright">Copyright ⓒ 2016 BRKOREA Company. All Rights
        Reserved.</p>
    </div>
  </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.bundle.min.js"></script>
-->
<script>
$(function() {
      $(document).on("click", "#footer_btn", function() {
        console.log($(this).attr('class'));
        let btn_class = $(this).attr('class');
         if(btn_class==""){
            $(this).attr('class', 'on');
         }else{
            $(this).removeClass('on');
         }
      });
});
</script>
</body>

</html>