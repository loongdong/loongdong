$(document).on("click","#onochk",function() {
	let ono = $(this).data("ono");
	console.log(">>>ono : "+ono);
	$.ajax({
		type: "post",
		url: "/order/modify",
		data:{ono:ono}, 
		success : function(result) {
			alert("수신확인완료");
			location.reload();
		}
	})
});


function printOrdlist(ordlist){
	// 지우고
	$("#orderList thead:first-child").nextAll().remove();
	console.log("컨트롤러에서 넘어온 값");
	
	console.log(ordlist);
	let jsondata = JSON.parse(ordlist);
	console.log(">>>jsondata : ");
	console.log(jsondata);
	// 분리완료
	

	let orderPtrTag = '<tbody>';
	let orderidx = 1;
	
	for (let ovo in jsondata) {
		let tempArr = jsondata[ovo];
		console.log(tempArr);
		orderPtrTag += '<tr><th>'+orderidx+'</th>';
		orderidx++;
		let myArray = { odate:tempArr.odate, ono:tempArr.ono, pname:tempArr.pname, price:tempArr.price,
				amount:tempArr.amount, receiver_id:tempArr.receiver_id, 
				 omemo:tempArr.memo, status:tempArr.status
		};
		console.log(myArray);
		for(let key in myArray){
			if(key=='status'){
				if(myArray[key]=='1'){
					orderPtrTag += '<th class="">미확인</th>';
				}else{
					orderPtrTag += '<th class="">확인완료</th>';
				}
			}else{
				orderPtrTag += '<th>'+myArray[key]+'</th>';	
			}
			}
	}
	orderPtrTag += '</tr></tbody>';
	$("#orderList").append(orderPtrTag).trigger("create");
}
function printOrdlist1(ordlist){
	// 지우고
	$("#orderList thead:first-child").nextAll().remove();
	console.log("컨트롤러에서 넘어온 값");
	
	console.log(ordlist);
	let jsondata = JSON.parse(ordlist);
	console.log(">>>jsondata : ");
	console.log(jsondata);
	// 분리완료
	

	let orderPtrTag = '<tbody>';
	let orderidx = 1;
	
	for (let ovo in jsondata) {
		let tempArr = jsondata[ovo];
		console.log(tempArr);
		orderPtrTag += '<tr><th>'+orderidx+'</th>';
		orderidx++;
		let myArray = { odate:tempArr.odate, ono:tempArr.ono, pname:tempArr.pname, price:tempArr.price,
				amount:tempArr.amount, receiver_id:tempArr.receiver_id, 
				 omemo:tempArr.memo, status:tempArr.status
		};
		console.log(myArray);
		for(let key in myArray){
			if(key=='status'){
				if(myArray[key]=='1'){
					orderPtrTag += '<th class="">미확인</th>';
					orderPtrTag += '<th class=""><button id="onochk" data-ono="'+myArray["ono"]+'" value ="'+myArray["ono"]+'">확인</button></th>';
				}else{
					orderPtrTag += '<th class="">확인완료</th>';
				}
			}else{
				orderPtrTag += '<th class="">'+myArray[key]+'</th>';	
			}
			}
	}
	orderPtrTag += '</tr></tbody>';
	$("#orderList").append(orderPtrTag).trigger("create");
}
function preOrderGet(pno){
	console.log("preOrderGet IN")
	$.getJSON("/order/preolist/"+pno+".json",function(plist){
		preolist = plist;
		console.log("printListpreoder 보내기전");
		console.log(plist);
		printpreolist(plist);
	}).fail(function(){
		alert("오더 리스트 출력 실패");
	});
}

// 주문삽입하는 페이지로 넘김
function addOrder(){
	
	console.log("addOrder 들어오나 확인");
	
    
    let pricelength = $(".preprice").length;
    let tempPname = "";
    let tempAmount = "";
    let tempMpoint = "";
    for (var i = 1; i < pricelength+1; i++) {
		let findid = "#idx"+i;
		console.log("findid : "+ findid);
		let standard = $("#preorderList").find(findid);
		tempPname += $(standard).closest("tr").find(".prepname").text() + ",";
		tempAmount += $(standard).closest("tr").find(".preamount").text() + ",";
	}
    console.log("tempPname보내기 전 :" +tempPname);
    console.log("tempAmount보내기 전 :" +tempAmount);
    console.log("보내기 직전 mno " + $("#ordermno").val());
    $("#orderpname").val(tempPname);
    $("#orderamount").val(tempAmount);
   
    $("#orderForm").submit();
}
function printpreolist(listArr){
	
	console.log("printpreolist IN")
	console.log(listArr);
	$("#preorderList thead:first-child").nextAll().remove();
	let ptrTag = '<tbody>';
	let idx = 1;
	for (let pvo of listArr) {
		total = total + pvo.price;
		console.log("total : "+ total);
		$("#total").val(total);
		$("#totalPrice").text("총 금액 : "+ total+"원");
		$("#mpoint").val(total/10);
		$("#totalMpoint").text("적립예정 포인트 : "+ (total/10)+"원");
		ptrTag += '<tr><th id = "idx'+idx+'"class="idx"><span>'+idx+'</span></th>';
		idx++;
		ptrTag += '<th class=""><img src="/images/'+pvo.pimg+'"></th>';
		ptrTag += '<th data-category="'+pvo.category+'" data-pno="'+pvo.pno+'" data-pname="'+pvo.pname+'" class="prepname">'+pvo.pname+'</th>';
		ptrTag += '<th value="'+pvo.price+'"><span data-price="'+pvo.price+'" class="preprice" >'+pvo.price+'</span></th>';
		ptrTag += '<th><span class="preamount">1</span><span><button data-price"'+pvo.price+'" type="button" class="mAnt btn btn-outline-light text-dark">-</button></span>'
		ptrTag += '<button type="button" class="pAnt btn btn-outline-light text-dark">+</button></span>';	
		ptrTag +='</th>';
		if(pvo.category == 'icecone'){
			ptrTag += '<th><button data-price=4000 id="ksize" class="checksize btn btn-outline-dark btn-block" >싱글킹(145g)</button>'
			ptrTag += '<button data-price=3200 id="rsize" class="basicclick checksize btn btn-outline-dark btn-block">싱글레귤러(115g)</button></th>'
			ptrTag += '</th>';
		}
		
	}
	ptrTag += '</tr></tbody>';
	$("#preorderList").append(ptrTag).trigger("create");
	// 기본값 선택 싱글레귤러
	$(".basicclick").trigger("click");
}

$(document).on("click",".checksize",function() {
	let nametr = $(this).closest("tr");
	let nametag = $(nametr).find(".prepname");
	let prepricetag = $(nametr).find(".preprice");
	let prepname = nametag.data("pname");
	console.log("prepname : "+prepname);
	let kname = prepname + $("#ksize").text();
	let rname = prepname + $("#rsize").text();
	let th = $(this).closest("th");
	let chkbtn = $(th).find(".checked");
	let length = $(chkbtn).length;
	let pricelength = $(".preprice").length;
	let mid = $('.checked').data("price");
    let priceval = $(this).data("price");
    // 눌렀을때의 수량
    let sizeamount = $(nametr).find(".preamount").text();
	 sizeamount *=1; 
	 console.log("사이즈버튼 눌렀을때 수량 값 : " + sizeamount);
	// 새로운가격 누른아이스크림가격 * 눌러져있던 수량
    let icecreamprice = priceval * sizeamount;
    icecreamprice *=1;
    // 텍스트값 변경
	$(prepricetag).text(icecreamprice);
	// 새로운 토탈값 만들어서넣기
	// tdoby:nth-child(i) .preprice:first-child.html
	console.log("pricelength:"+pricelength);
	let price = 0;
	for (var i = 1; i < pricelength+1; i++) {
		let findid = "#idx"+i;
		console.log("findid : "+ findid);
		let standard = $("#preorderList").find(findid);
		let stx = standard.text();
		console.log(standard);
		console.log(">>>stx "+ stx);
		let tempPrice = $(standard).closest("tr").find(".preprice").text();
		tempPrice *=1;
		price = price + tempPrice; 
		console.log(price);
		$("#total").val(price);
		$("#mpoint").val(price/10);
	}

	
	
	if(length!=0){
		
		$(chkbtn).attr("class","checksize btn btn-outline-dark btn-block");
	}
		$(this).attr("class", "checked btn btn-dark btn-block");
	
	        if(priceval == 3200){
	        	nametag.text(rname);
	        }else if(priceval == 4000){
	        	nametag.text(kname);
	        }
});


// + 눌렀을때
$(document).on("click",".pAnt",function(){ 
	let thamount = $(this).closest("th");
	let tramount = $(this).closest("tr");
	// 내가 선택한 상품의 기본값
	let realprice = $(tramount).find(".preprice").data("price");
	let icechk = $(tramount).find(".prepname").data("category");
	if(icechk == 'icecone'){
		realprice = $(tramount).find(".checked").data("price");
	}
	
	realprice *=1;
	// 플마 버튼 눌렀을때 수량값 기본 1
	let amountspan = $(thamount).find(".preamount");
	let pamount = $(amountspan).text();
	pamount *=1;
	
	if(pamount<10){
		pamount++;
		$(amountspan).text(pamount);
		pamount *=1;
		let newprice1 = realprice*pamount;
		$(tramount).find(".preprice").text(newprice1);
		let iceprice = $(tramount).find(".preprice").text();
		iceprice *=1;
		let price = 0;
		let pricelength = $(".preprice").length;
		console.log(">>> +버튼 pricelength" + pricelength);
 		for (var i = 1; i < pricelength+1; i++) {
 			let findid = "#idx"+i;
 			console.log("findid : "+ findid);
 			let standard = $("#preorderList").find(findid);
 			let stx = standard.text();
 			console.log(standard);
 			console.log(">>>stx "+ stx);
 			let tempPrice = $(standard).closest("tr").find(".preprice").text();
 			tempPrice *=1;
 			price = price + tempPrice; 
 			console.log(price);
 			$("#total").val(price);
 			$("#mpoint").val(price/10);
 		}
	}
});

$(document).on("click",".mAnt",function(){
	let thamount = $(this).closest("th");
	let tramount = $(this).closest("tr");
	// 내가 선택한 상품의 기본값
	let realprice = $(tramount).find(".preprice").data("price");
	let icechk = $(tramount).find(".prepname").data("category");
	if(icechk == 'icecone'){
		realprice = $(tramount).find(".checked").data("price");
	}
	realprice *=1;
	// 플마 버튼 눌렀을때 수량값 기본 1
	let amountspan = $(thamount).find(".preamount");
	let pamount = $(amountspan).text();
	pamount *=1;
	
	if(pamount>1){
		pamount--;
		$(amountspan).text(pamount);
		pamount *=1;
		let newprice1 = realprice*pamount;
		$(tramount).find(".preprice").text(newprice1);
		let iceprice = $(tramount).find(".preprice").text();
		iceprice *=1;
		let price = 0;
		let pricelength = $(".preprice").length;
		
		console.log(">>> -버튼 pricelength" + pricelength);
 		for (var i = 1; i < pricelength+1; i++) {
 			let findid = "#idx"+i;
 			console.log("findid : "+ findid);
 			let standard = $("#preorderList").find(findid);
 			let stx = standard.text();
 			console.log(standard);
 			console.log(">>>stx "+ stx);
 			let tempPrice = $(standard).closest("tr").find(".preprice").text();
 			tempPrice *=1;
 			price = price + tempPrice; 
 			console.log(price);
 			$("#total").val(price);
 			$("#mpoint").val(price/10);
 		}
		
	}
});

