package com.myweb.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.domain.CartDTO;
import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;
import com.myweb.service.CartService;
import com.myweb.service.OrderService;
import com.myweb.service.ProductService;

@Controller
@RequestMapping("/order/*")
public class OrderCtrl {
	private static Logger log = LoggerFactory.getLogger(OrderCtrl.class);

	@Inject
	OrderService osv;
	@Inject
	CartService csv;
	@Inject
	ProductService psv;

	@GetMapping(value = "/preolist/{pno}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ProductVO>> preolist(@PathVariable("pno") String pno) {

		List<ProductVO> plist = new ArrayList<ProductVO>();
		String[] pArr = pno.split(",");
		log.info("pArr.length : " + pArr.length);

		for (int i = 0; i < pArr.length; i++) {
			log.info(">>>" + pArr[i]);
			int pno1 = Integer.parseInt(pArr[i]);
			ProductVO pvo = psv.getpdetail(pno1);
			plist.add(pvo);
			log.info(">>> pvo.category" + plist.get(i).getCategory());
		}

		return new ResponseEntity<List<ProductVO>>(plist,HttpStatus.OK);
	}

	@PostMapping("/ocheck")
	public void prelist(Model model, @RequestParam("cno") String cno, @RequestParam("pno") String pno) {
		/*
		 * String[] pArr = pno.split(","); List<ProductVO> plist = new
		 * ArrayList<ProductVO>(); for (int i = 0; i < pArr.length; i++) {
		 * log.info(">>>" + pArr[i]); int pno1 = Integer.parseInt(pArr[i]); ProductVO
		 * pvo = psv.getpdetail(pno1); plist.add(pvo); } model.addAttribute("plist",
		 * plist);
		 */
		model.addAttribute("cno", cno);
		model.addAttribute("pno", pno);
		/*
		 * log.info(">>> pno : " + pno); log.info(">>> cno : " + cno);
		 */
	}

	/*
	 * @GetMapping(value = "/list/{mno}/{cno}/{page}", produces = {
	 * MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	 * public ResponseEntity<CartDTO> list(@PathVariable("mno") int
	 * mno, @PathVariable("page") int page) { // ArrayList<CommentVO> cList =
	 * (ArrayList<CommentVO>) csv.getList(pno); Criterion cri = new Criterion(page,
	 * 10); //csv.getList(cri, mno).getClist(); //return new
	 * ResponseEntity<CartDTO>(csv.getList(cri, mno), HttpStatus.OK); }
	 */
}
