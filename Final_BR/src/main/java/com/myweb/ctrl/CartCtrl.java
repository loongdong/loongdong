package com.myweb.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.domain.CartDTO;
import com.myweb.domain.CartVO;
import com.myweb.domain.Criterion;
import com.myweb.domain.PagingVO;
import com.myweb.service.CartService;

@Controller
@RequestMapping("/cart/*")
public class CartCtrl {
	private static Logger log = LoggerFactory.getLogger(CartCtrl.class);

	@Inject
	CartService csv;

	@GetMapping("/add")
	public String add(CartVO cvo) {
		log.info("mno : " + cvo.getMno());
		log.info("pno : " + cvo.getPno());
		csv.addCart(cvo);
		return "redirect:/order/totalinfo?cate=2";
	}

	@PostMapping("/del")
	public String del(@RequestParam("cno") String cno) {
		log.info(">>> cno : " + cno);
		String[] arr = cno.split(",");
		log.info(">>> arr : " + arr);
		for (int i = 0; i < arr.length; i++) {
			log.info(arr[i]);
			int cno1 = Integer.parseInt(arr[i]);
			csv.delCart(cno1);
		}
		return "redirect:/product/cart";
	}

	@GetMapping(value = "/list/{mno}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CartDTO> list(@PathVariable("mno") int mno, @PathVariable("page") int page) {
		// ArrayList<CommentVO> cList = (ArrayList<CommentVO>) csv.getList(pno);
		Criterion cri = new Criterion(page, 10);

		return new ResponseEntity<CartDTO>(csv.getList(cri, mno), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/test") public void test(@RequestParam("price") int price) {
	 * String bt = "'1,2,3,4'"; log.info(">>>bt : " + bt);
	 * 
	 * String test = csv.getTest(price); log.info(">>>test : " + test); String[]
	 * array = test.split(","); log.info(">>>array : " + array); for (int i = 0; i <
	 * array.length; i++) { log.info(array[i]); }
	 * 
	 * }
	 */

}
