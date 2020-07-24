
//모달파트
function transferToRvModal(mid, mimg, rimg, r_title, r_content, r_regd8,r_count,r_size,rno,r_like){
	let rvimgTag = "";
	let memberTag = "";
	let memberTag2 = "";
	let r_titleTag = "";
	let r_hiddenTag = "";
	console.log(">>> memberTag1 : " + memberTag);
	console.log("rtitle : "+ r_title);
	
	rvimgTag += '<img src="/images/review/'+rimg+'">';
	memberTag += '<img src="/images/review/'+mimg+'">';
	memberTag += '<span id="mid">'+mid+'</span>&nbsp;';
	memberTag += '<div style="float : right"><i class="fa fa-heart" style="font-size:24px;color:red"></i><span id="rlike"> '+r_like+'</span>개<div>';
	
	
	// memberTag2 += '<span id="rdate">'+r_regd8+'</span>';
	r_titleTag += '<span>'+r_title+'</span><br><br>';
	r_titleTag += '<p>'+r_content+'</p>';
	r_hiddenTag += '<input type="hidden" name="rvSize" value="'+r_size+'">';
	r_hiddenTag += '<input type="hidden" name="rvCount" value="'+r_count+'">';
	r_hiddenTag += '<input type="hidden" name="rno" value="'+rno+'">';
	console.log(">>> memberTag : " + memberTag);
	
	$(document).find(".rvLeft").html(rvimgTag);
	$(document).find("#rv_member").html(memberTag);
	$(document).find("#rv_content").html(r_titleTag);
	$(document).find("#rv_hidden").html(r_hiddenTag);
	$(document).find("#rlike").text(r_like);
}




// 다음 / 이전버튼 클릭기능
$(document).on("click", ".rv_prev", function() {
	console.log(">>--들어오나확인");
	let count = $("#rv_hidden").find("input[name=rvCount]").val();
	let total = $("#rv_hidden").find("input[name=rvSize]").val();
	
	if(count>1){
		$('#rvModal').modal('hide');
		count--;
		$("#rv_"+count+"").trigger("click");
	}
});
$(document).on("click", ".rv_next", function() {
	let parentsDiv = $(this).closest("div");
	let count = $(parentsDiv).find("input[name=rvCount]").val();
	let total = $(parentsDiv).find("input[name=rvSize]").val();
	if(total>count){
		$('#rvModal').modal('hide');
		count++;
		$("#rv_"+count+"").trigger("click");
	}
});

// 모달 좋아요 클릭 기능
// 속성주기color:red
$(document).on("click", ".addlike", function() {
	
	console.log("들어오나확인");
	let heart =$(document).find("#r_heart");
	console.log(heart);
	heart.removeClass('addlike');
	heart.addClass('bg_red');
	let parentsDiv = $(this).closest("div");
	let rno = $(parentsDiv).find("input[name=rno]").val();
	let likes = $(document).find("#rlike").text();
	addlike(rno,likes);
	
});

function addlike(rno,likes){
	let n_likes = 0;
	n_likes = 1*likes;
	
	$.ajax({
		type: "post",
		url: "/review/addlike",
		data:{rno:rno},
		success : function(result) {
			n_likes++;
			$(document).find("#rlike").text(n_likes);
		}
	})
}













function listCart(param_mno,page){
	let pageNo = page> 1 ? page : 1;
	$.getJSON("/cart/list/"+param_mno+"/"+pageNo+".json",function(cdto){
		console.log("printListCart 보내기전");
		console.log(cdto.clist);
		printListCart(cdto.clist,cdto.cartCnt,pageNo);
	}).fail(function(){
		alert("카트 리스트 출력 실패");
	});
}
function printListCart(listArr,cartTotal,page){
	console.log("printListCart IN")
	
	console.log(listArr);
	$("#cartList thead:first-child").nextAll().remove();
	let ulTag = '<tbody>';
	for (let cvo of listArr) {
		console.log(cvo.pimg);
		ulTag += '<tr><th class=""><input type="checkbox" value="'+cvo.cno+'"></th>';
		ulTag += '<th class=""><img src="/images/'+cvo.pimg+'"></th>';
		ulTag += '<th class="">'+cvo.pname+'</th>';
		ulTag += '<th class="">'+cvo.price+'</th>';
		ulTag += '<th class="">0p</th>';
		ulTag += '<th><button id="ordOneBtn" class="btn btn-outline-danger" data-pno="'+cvo.pno+'">구매하기</button><th></tr>';
	}
	
	ulTag += '</tbody>';
	$("#cartList").append(ulTag).trigger("create");
	// printCartPaging(cartTotal,page);
}



// 구매하기 버튼 눌렀을때 하나만 주문하기
$(document).on("click", "#ordOneBtn", function(e) {
	e.preventDefault(e);
	console.log("하ㅓ나 주문하는 곳 들어오는가 확인");
	
	let pno2 = $(this).data("pno");
	console.log(">>>pno2 : " + pno2);
	let onetr = $(this).closest("tr");
	let cno2 = onetr.find("input").val();
	console.log(">>>cno2 : " +cno2);
	$("#prePno").val(pno2);
    $("#preCno").val(cno2);
    $("#goOrder").submit();
});



function ordFromCart(){
	
    var cnos = document.cartForm;
    var cno = "";
    var pno = "";  
    // mno세션에서 가져오기
    var mno = 1;
    var i;
    for (i = 1; i < cnos.length-1; i++) {
      if (cnos[i].checked) {
        cno = cno + cnos[i].value + ",";
        console.log(cnos[i]);
        let tag = cnos[i].closest("tr");
        console.log(tag);
        let btn = $(tag).find("button");
        pno = pno + btn.data("pno") + ",";
        console.log("pno : "+ pno);
        console.log("cno : "+ cno);
      }
    }
    // pno, cno 보내기
    
    // input type hidden
    $("#prePno").val(pno);
    $("#preCno").val(cno);
    
    $("#goOrder").submit();
          
    /*
	 * $.ajax({ url : "/order/ocheck", type : "post", data : { pno : pno, cno :
	 * cno } });
	 */
}

// 카트페이징기능삭제
/*
 * function printCartPaging(cartTotal,page){ let cartPagingObj = '<ul class="pagination">';
 * let endPagingNum = Math.ceil(page/10.0)*10; let beginPagingNum = endPagingNum -
 * 9; let prev = beginPagingNum != 1; let next = false;
 * 
 * if(endPagingNum*10 >= cartTotal){ endPagingNum = Math.ceil(cartTotal/10.0);
 * }else{ next = true; }
 * 
 * if(prev){ cartPagingObj += '<li class="page-item">'; cartPagingObj += '<a
 * class="page-link" href="'+(beginPagingNum-1)+'">Prev</a></li>'; } for (var
 * i = beginPagingNum; i <= endPagingNum ; i++) { let classActive = page == i ? '
 * active' : ''; cartPagingObj += '<li class="page-item'+classActive+'">';
 * cartPagingObj += '<a class="page-link" href="'+i+'">'+i+'</a></li>'; }
 * if(next){ cmtPagingObj += '<li class="page-item">'; cmtPagingObj += '<a
 * class="page-link" href="'+(endPagingNum+1)+'">Next</a></li>'; }
 * cartPagingObj += '</ul>'; $("#cartPaging").html(cartPagingObj); }
 */

function chkAll(){
	console.log("클릭되는지확인");
	var cnos = document.cartForm;
	 console.log(cnos);
	 if( $("#checkAll").is(':checked') ){
		
		 for (i = 1; i < cnos.length-1; i++) {
		     cnos[i].checked  =true;
		     console.log(cnos[i]);
		    }
	      }else{
	    	  for (i = 1; i < cnos.length-1; i++) {
	 		     cnos[i].checked  =false;
	 		    }
	      }
}
function addCart(mno,pno){
	console.log("mno"+mno);
	console.log("pno"+pno);
	$.ajax({
		type: "post",
		url: "/cart/add",
		data:{mno:mno, pno:pno}
	})
}


function delCart() {
    var cnos = document.cartForm;
    console.log(cnos);
    var cno = "";
    var i;
    for (i = 0; i < cnos.length; i++) {
      if (cnos[i].checked) {
        cno = cno + cnos[i].value + ",";
      }
    }
    console.log("cno : "+ cno);
	$.ajax({
		url : "/cart/del",
		type : "post",
		data : {
			cno : cno
		}, 
		success : function(result) {
			alert("카트목록삭제성공");
			location.reload();
		}
	});
  }

function chkDuple(mno, pno){
	$.ajax({
		url : "./cart/chkDuple",
		type : "get",
		data : {
			mno : mno,
			pno : pno
		}, 
		success : function(result) {
			if (result > 0) {
			addCart(mno,pno);
			} else {
				alert("이미카트에있는상품입니다")
			}
		}
	});
}



/*
 * function displayTime(modd8){ console.log("modd8 변환전 : " + modd8); let today =
 * new Date(); let changeModd8 = new Date(modd8); console.log("today : "+
 * today); console.log("changeModd8 : "+ changeModd8);
 * 
 * 
 * let todayYear = today.getFullYear(); console.log("today : "+todayYear); let
 * todayMonth = today.getMonth()+1; // 0~11 console.log("today : "+ todayMonth);
 * let todayDate = today.getDate(); console.log("todayDate : "+ todayDate); let
 * modYear = changeModd8.getFullYear(); console.log("modYear : "+ modYear); let
 * modMonth = changeModd8.getMonth()+1; console.log("modMonth : "+ modMonth);
 * let modDate = changeModd8.getDate(); console.log("modDate : "+ modDate);
 * 
 * let modHour = changeModd8.getHours(); let modMin = changeModd8.getMinutes();
 * let modSec = changeModd8.getSeconds();
 * 
 * let hour = (modHour > 9 ? "" :"0") + modHour; let min = (modMin > 9 ? "" :
 * "0") + modMin; let sec = (modSec > 9 ? "" : "0") + modSec; let month =
 * (modMonth > 9 ? "" : "0") + modMonth; let day = (modDate > 9 ? "" : "0") +
 * modDate; console.log(hour+":"+min+":"+sec);
 * 
 * let diff = todayYear == modYear && todayMonth == modMonth && todayDate ==
 * modDate; let dateStr = modYear+"-"+month+"-"+day; let timeStr =
 * hour+":"+min+":"+sec; console.log(dateStr + " / " + timeStr); return diff ?
 * timeStr : dateStr + " " + timeStr; }
 * 
 */