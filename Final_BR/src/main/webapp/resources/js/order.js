
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

//주문삽입하는 페이지로 넘김
function addOrder(){
	// mno세션에서 가져오기
    var mno = 1;
    var pnames = "";
    
    let plength = $('.prepname').length
    console.log("plength : " + plength);
    
    for (i = 1; i < plength+1; i++) {
    	pnames = pnames + $(".prepname:nth-child("+i+")").text() + ",";
    }
    console.log(pnames);
}

function printpreolist(listArr){
	
	console.log("printpreolist IN")
	console.log(listArr);
	$("#preorderList thead:first-child").nextAll().remove();
	let trTag = '<tbody>';
	
	for (let pvo of listArr) {
		total = total + pvo.price;
		console.log("total : "+ total);
		$("#total").val(total);
		$("#mpoint").val(total/10);
		trTag += '<tr><th class=""><img src="/resources/img/img_IC/'+pvo.pimg+'"></th>';
		trTag += '<th data-pno="'+pvo.pno+'" data-pname="'+pvo.pname+'" class="prepname">'+pvo.pname+'</th>';
		trTag += '<th class="preprice"  value="'+pvo.price+'">'+pvo.price+'</th>';
		if(pvo.category == 'icecone'){
			trTag += '<th><button data-price=4000 id="ksize" class="checksize btn btn-outline-dark btn-block" >싱글킹(145g)</button>'
			trTag += '<button data-price=3200 id="rsize" class="checksize btn btn-outline-dark btn-block">싱글레귤러(115g)</button></th></tr>';
		}else
		trTag += '<th></th></tr>';
	}
	trTag += '</tbody>';
	$("#preorderList").append(trTag).trigger("create");
}
$(document).on("click",".checksize",function() {
	let nametr = $(this).closest("tr");
	let nametag = $(nametr).find(".prepname");
	let prepname = nametag.data("pname");
	console.log("prepname : "+prepname);
	let kname = prepname + $("#ksize").text();
	let rname = prepname + $("#rsize").text();
	
	   // $(".checked").attr("class","checksize btn btn-outline-dark
		// btn-block");
	let th = $(this).closest("th");
	let chkbtn = $(th).find(".checked");
	 let length = $(chkbtn).length;
	if(length!=0){
		let minuspoint = $(chkbtn).data("price");
		console.log("minuspoint : " + minuspoint);
		minuspoint *=1;
		total = total-minuspoint;
		$(chkbtn).attr("class","checksize btn btn-outline-dark btn-block");
	}
		$(this).attr("class", "checked btn btn-dark btn-block");
		pluspoint = $(this).data("price");
		pluspoint *=1;
		total = total +pluspoint;
		$("#total").val(total);
		$("#mpoint").val(total/10);
		let mid = $('.checked').data("price");
		
		let newprice = $(this).data("price");
		let tr = $(this).closest("tr");
	        let choiceprice = $(tr).find(".preprice");
		$(choiceprice).text(newprice);
	        $(choiceprice).attr('value',newprice);
	        let priceval = $(choiceprice).attr('value');
	        console.log("priceval : "+ priceval);
	        if(priceval == 3200){
	        	nametag.text(rname);
	        }else if(priceval == 4000){
	        	nametag.text(kname);
	        }
	        let addprice = $(".checked").data("price");
	        addprice *=1;
	        console.log("addprice : "+addprice);
});

