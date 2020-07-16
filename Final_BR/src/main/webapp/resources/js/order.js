
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


function printpreolist(listArr){
	
	console.log("printpreolist IN")
	console.log(listArr);
	$("#preorderList thead:first-child").nextAll().remove();
	let trTag = '<tbody>';
	
	for (let pvo of listArr) {
		total = total + pvo.price;
		console.log("total : "+ total);
		$("#total").text(total);
		trTag += '<tr><th class=""><img src="/resources/img/img_IC/'+pvo.pimg+'"></th>';
		trTag += '<th data-pno="'+pvo.pno+'" class="">'+pvo.pname+'</th>';
		trTag += '<th class="preprice"  value="'+pvo.price+'">'+pvo.price+'</th>';
		trTag += '<th class="">0p</th>';
		if(pvo.category == 'icecone'){
			trTag += '<th><button data-price=3200 class="checksize btn btn-outline-dark btn-block">싱글레귤러(115g)</button>'
			trTag += '<button data-price=4000 class="checksize btn btn-outline-dark btn-block">싱글킹(145g)</button></th></tr>';
		}else
		trTag += '<th></th></tr>';
		
	}
	trTag += '</tbody>';
	$("#preorderList").append(trTag).trigger("create");
}

$(document).on("click",".checksize",function() {
	
	   // $(".checked").attr("class","checksize btn btn-outline-dark
		// btn-block");
	let th = $(this).closest("th");
	let chkbtn = $(th).find(".checked");
	console.log(chkbtn);
	$(chkbtn).attr("class","checksize btn btn-outline-dark btn-block");
		$(this).attr("class", "checked btn btn-dark btn-block");
		
		console.log("작업전 total : " + total);
		let minuspoint = $(chkbtn).data("price");
		console.log("minuspoint : " + minuspoint);
		minuspoint *=1;
		total = total-minuspoint;
		console.log("뺀 후에 total :" + total);
		pluspoint = $(this).data("price");
		pluspoint *=1;
		total = total +pluspoint;
		console.log("더한 후에 total :" + total);
		$("#total").text(total);
		let mid = $('.checked').data("price");
		console.log("중간과정 : " + mid);
		
		let newprice = $(this).data("price");
		let tr = $(this).closest("tr");
	        let choiceprice = $(tr).find(".preprice");
		$(choiceprice).text(newprice);
	        $(choiceprice).attr('value',newprice);
	        let addprice = $(".checked").data("price");
	        addprice *=1;
	        console.log("addprice : "+addprice);
	       
	        
	       
	  /*
		 * let length = $('.checked').length; console.log("length : " +length );
		 * var num = 0; for (var i = 1; i < length+1; i++) {
		 * console.log($('.checked:nth-child('+i+')').data("price")); num +=
		 * $('.checked:nth-child('+i+')').data("price"); num = parseFloat(num
		 * ==""?0:num); console.log("num : "+ num) } let newtotal = total + num;
		 * newtotal *= 1; console.log("newtotal :" + newtotal);
		 */
	        

});

