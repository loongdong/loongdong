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
		
		ulTag += '<tr><th class=""><input type="checkbox" value="'+cvo.cno+'"></th>';
		ulTag += '<th class="">'+cvo.pname+'</th>';
		ulTag += '<th class=""><img src="/resources/img/img_IC/'+cvo.pimg+'"></th>';
		ulTag += '<th class="">'+cvo.price+'</th>';
		ulTag += '<th class="">0p</th>';
		ulTag += '<th><button class="btn btn-outline-danger" data-pno="'+cvo.pno+'">구매하기</button><th></tr>';
		
	}
	
	
	ulTag += '</tbody>';
	$("#cartList").append(ulTag).trigger("create");
	printCartPaging(cartTotal,page);
}


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
    $("#prePno").val(pno);
    $("#preCno").val(cno);
    let cno2 = $("#prePno").val();
    let pno2 = $("#preCno").val();
    console.log(cno2);
    console.log(pno2);
    
    $("#goOrder").submit();
          
    /* $.ajax({
		url : "/order/ocheck",
		type : "post",
		data : {
			pno : pno,
			cno : cno
		}
	});*/
}

function printCartPaging(cartTotal,page){
	let cartPagingObj = '<ul class="pagination">';
	let endPagingNum = Math.ceil(page/10.0)*10;
	let beginPagingNum = endPagingNum - 9;
	let prev = beginPagingNum != 1;
	let next = false;
	
	if(endPagingNum*10 >= cartTotal){
		endPagingNum = Math.ceil(cartTotal/10.0);		
	}else{
		next = true;
	}
	
	if(prev){
		cartPagingObj += '<li class="page-item">';
		cartPagingObj += '<a class="page-link" href="'+(beginPagingNum-1)+'">Prev</a></li>';
	}
	for (var i = beginPagingNum; i <= endPagingNum ; i++) {
		let classActive = page == i ? ' active' : '';
		cartPagingObj += '<li class="page-item'+classActive+'">';
		cartPagingObj += '<a class="page-link" href="'+i+'">'+i+'</a></li>';
	}
	if(next){
		cmtPagingObj += '<li class="page-item">';
		cmtPagingObj += '<a class="page-link" href="'+(endPagingNum+1)+'">Next</a></li>';
	}
	cartPagingObj += '</ul>';
	$("#cartPaging").html(cartPagingObj);
}

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

