
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
	// mno세션에서 가져오기
    var mno = 1;
    let pricelength = $(".preprice").length;
    let tempPname = "";
    let tempAmount = "";
    for (var i = 1; i < pricelength+1; i++) {
		let findid = "#idx"+i;
		console.log("findid : "+ findid);
		let standard = $("#preorderList").find(findid);
		tempPname += $(standard).closest("tr").find(".prepname").text() + ",";
		tempAmount += $(standard).closest("tr").find(".preamount").text() + ",";
	}
    console.log("tempPname보내기 전 :" +tempPname);
    console.log("tempAmount보내기 전 :" +tempAmount);
    let tempTotal = $("total").text();
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
		$("#mpoint").val(total/10);
		ptrTag += '<tr><th id = "idx'+idx+'"class="idx"><span>'+idx+'</span></th>';
		idx++;
		ptrTag += '<th class=""><img src="/resources/img/img_IC/'+pvo.pimg+'"></th>';
		ptrTag += '<th data-category="'+pvo.category+'" data-pno="'+pvo.pno+'" data-pname="'+pvo.pname+'" class="prepname">'+pvo.pname+'</th>';
		ptrTag += '<th value="'+pvo.price+'"><span data-price="'+pvo.price+'" class="preprice" >'+pvo.price+'</span></th>';
		ptrTag += '<th><span class="preamount">1</span><span><button data-price"'+pvo.price+'" type="button" class="mAnt btn btn-outline-light text-dark">-</button></span>'
		ptrTag += '<button type="button" class="pAnt btn btn-outline-light text-dark">+</button></span>';	
		ptrTag +='</th>';
		if(pvo.category == 'icecone'){
			ptrTag += '<th><button data-price=4000 id="ksize" class="checksize btn btn-outline-dark btn-block" >싱글킹(145g)</button>'
			ptrTag += '<button data-price=3200 id="rsize" class="checksize btn btn-outline-dark btn-block">싱글레귤러(115g)</button></th>'
			ptrTag += '</th>';
		}
		
	}
	
	ptrTag += '</tr></tbody>';
	$("#preorderList").append(ptrTag).trigger("create");
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


//+ 눌렀을때
$(document).on("click",".pAnt",function(){ 
	let thamount = $(this).closest("th");
	let tramount = $(this).closest("tr");
	//내가 선택한 상품의 기본값
	let realprice = $(tramount).find(".preprice").data("price");
	let icechk = $(tramount).find(".prepname").data("category");
	if(icechk == 'icecone'){
		realprice = $(tramount).find(".checked").data("price");
	}
	
	realprice *=1;
	//플마 버튼 눌렀을때 수량값 기본 1
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
	//내가 선택한 상품의 기본값
	let realprice = $(tramount).find(".preprice").data("price");
	let icechk = $(tramount).find(".prepname").data("category");
	if(icechk == 'icecone'){
		realprice = $(tramount).find(".checked").data("price");
	}
	realprice *=1;
	//플마 버튼 눌렀을때 수량값 기본 1
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

