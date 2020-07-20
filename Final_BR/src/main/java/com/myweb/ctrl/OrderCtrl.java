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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.TotalDigitsFacet;
import com.myweb.domain.MemberVO;
import com.myweb.domain.OrderVO;
import com.myweb.domain.ProductVO;
import com.myweb.service.CartService;
import com.myweb.service.MemberService;
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
	@Inject
	MemberService msv;

	@GetMapping("/list")
	public void olist() {

	}

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

		return new ResponseEntity<List<ProductVO>>(plist, HttpStatus.OK);
	}

	@PostMapping("/buylist")
	public void buylist(Model model, @RequestParam("mno") int mno) {
		log.info(">>>buylist : mno" + mno);
		List<OrderVO> olist = osv.getbuyList(mno);
		log.info(">>>olist : " + olist);
		for (int i = 0; i < olist.size(); i++) {
			log.info(">>> olist)" + olist.get(i).getPname());
			log.info(">>> olist)" + olist.get(i).getAmount());
		}
	}

	@PostMapping("/presentlist")
	public void presentlist(Model model, @RequestParam("receiver_id") String receiver_id) {
		log.info(">>>receiver_id : " + receiver_id);
		List<OrderVO> templist = osv.getpresentList(receiver_id);
		log.info(">>>olist : " + templist);
		List<OrderVO> olist = new ArrayList<OrderVO>();
		for (int i = 0; i < templist.size(); i++) {
			log.info(">>> olist)" + templist.get(i).getPname());
			log.info(">>> olist)" + templist.get(i).getAmount());
			String[] pnameArr = templist.get(i).getPname().split(",");
			String[] amountArr = templist.get(i).getAmount().split(",");
			log.info("pnameArr.length : " + pnameArr.length);
			for (int j = 0; j < pnameArr.length; i++) {
				OrderVO ovo = new OrderVO();
				ovo.setOno(templist.get(i).getOno());
				ovo.setMemo(templist.get(i).getMemo());
				ovo.setOdate(templist.get(i).getOdate());
				ovo.setPname(pnameArr[j]);
				ovo.setAmount(amountArr[j]);
				ovo.setReceiver_id(receiver_id);
				ovo.setStatus(templist.get(i).getStatus());
				int price = psv.getPrice(pnameArr[j]);
				ovo.setPrice(price);
				olist.add(ovo);
			}
		}
		log.info(">>> 테스트용"+  olist.get(0).getAmount());
		model.addAttribute("presentlist", olist);
	}

	@PostMapping(value = "/ocheck")
	public void prelist(Model model, @RequestParam("cno") String cno, @RequestParam("pno") String pno) {

		log.info(">>>cno : " + cno);
		log.info(">>>pno : " + pno);
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

	@GetMapping("/ofinal")
	public void ofinal(@RequestParam("mpoint") String mpoint, @RequestParam("totalMpoint") String totalMpoint,
			Model model) {
		model.addAttribute("totalMpoint", totalMpoint);
		model.addAttribute("mpoint", mpoint);
	}

	@PostMapping(value = "/add", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public String addOrder(OrderVO ovo, @RequestParam("mno") String mno, @RequestParam("cno") String cno,
			@RequestParam("mpoint") String mpoint, Model model) {

		int totalMpoint = 0;

		if (osv.insertOrder(ovo) > 0) {
			int mno1 = Integer.parseInt(mno);
			int mpoint1 = Integer.parseInt(mpoint);
			log.info(">>>>mpoint1" + mpoint1);
			MemberVO mvo = new MemberVO(mno1, mpoint1);
			totalMpoint = msv.addmpoint(mvo);

			String[] cArr = cno.split(",");
			log.info("cArr.length : " + cArr.length);
			for (int i = 0; i < cArr.length; i++) {
				log.info(">>>" + cArr[i]);
				int cno1 = Integer.parseInt(cArr[i]);
				csv.delCart(cno1);
			}
		}

		model.addAttribute("mpoint", mpoint);
		model.addAttribute("totalMpoint", totalMpoint);
		return "redirect:/order/ofinal";
	}
}
