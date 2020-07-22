package com.myweb.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.TotalDigitsFacet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
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

	@ResponseBody
	@PostMapping("/getmpoint")
	public String getmpoint(@RequestParam("mno") int mno) {
		log.info(">>> 여기오나");
		String result = String.valueOf(msv.getmpoint(mno));
		return result;
	}
	
	@ResponseBody
	@PostMapping("/modify")
	public int ordchk(@RequestParam("ono") int ono) {
		log.info(">>> 여기오나");
		int isOk = osv.ordchk(ono);
		return isOk;
	}

	@GetMapping("/totalinfo")
	public void totalinfo(Model model, @RequestParam("cate") String cate) {
		model.addAttribute("cate", cate);
	}

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

	@ResponseBody
	@PostMapping(value = "/buylist", produces = "application/text; charset=utf8")

	public String buylist(Model model, @RequestParam("mno") int mno) {
		String json = "";
		List<OrderVO> templist = osv.getbuyList(mno);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();

		for (int i = 0; i < templist.size(); i++) {

			String[] pnameArr = templist.get(i).getPname().split(",");
			String[] amountArr = templist.get(i).getAmount().split(",");
			log.info("pnameArr.length : " + pnameArr.length);
			for (int j = 0; j < pnameArr.length; j++) {
				OrderVO ovo = new OrderVO();
				ovo.setMno(templist.get(i).getMno());
				ovo.setOno(templist.get(i).getOno());
				ovo.setMemo(templist.get(i).getMemo());
				ovo.setOdate(templist.get(i).getOdate());
				ovo.setPname(pnameArr[j]);
				ovo.setAmount(amountArr[j]);
				ovo.setReceiver_id(templist.get(i).getReceiver_id());
				ovo.setStatus(templist.get(i).getStatus());
				int price = psv.getPrice(pnameArr[j]);
				ovo.setPrice(price);
				map.put("ovo" + i, ovo);
			}
		}
		try {
			json = mapper.writeValueAsString(map);
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(">>>>>" + json);
		return json;
	}

	@ResponseBody
	@PostMapping(value = "/presentlist", produces = "application/text; charset=utf8")
	public String presentlist(Model model, @RequestParam("receiver_id") String receiver_id) {
		log.info(">>>receiver_id : " + receiver_id);
		List<OrderVO> templist = osv.getpresentList(receiver_id);
		log.info(">>>olist : " + templist);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		String json = "";
		for (int i = 0; i < templist.size(); i++) {
			log.info(">>> olist)" + templist.get(i).getPname());
			log.info(">>> olist)" + templist.get(i).getAmount());
			String[] pnameArr = templist.get(i).getPname().split(",");
			String[] amountArr = templist.get(i).getAmount().split(",");
			log.info("pnameArr.length : " + pnameArr.length);
			for (int j = 0; j < pnameArr.length; j++) {
				OrderVO ovo = new OrderVO();
				ovo.setMno(templist.get(i).getMno());
				ovo.setOno(templist.get(i).getOno());
				ovo.setMemo(templist.get(i).getMemo());
				ovo.setOdate(templist.get(i).getOdate());
				ovo.setPname(pnameArr[j]);
				ovo.setAmount(amountArr[j]);
				ovo.setReceiver_id(receiver_id);
				ovo.setStatus(templist.get(i).getStatus());
				int price = psv.getPrice(pnameArr[j]);
				ovo.setPrice(price);
				map.put("ovo" + i, ovo);
			}

		}
		try {
			json = mapper.writeValueAsString(map);
			log.info(json);
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			log.info(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(">>>>>" + json);
		return json;
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

	@GetMapping(value = "/ocheck")
	public void ordfromdetail(Model model, @RequestParam("pno") String pno) {
		log.info(">>>pno : " + pno);
		/*
		 * String[] pArr = pno.split(","); List<ProductVO> plist = new
		 * ArrayList<ProductVO>(); for (int i = 0; i < pArr.length; i++) {
		 * log.info(">>>" + pArr[i]); int pno1 = Integer.parseInt(pArr[i]); ProductVO
		 * pvo = psv.getpdetail(pno1); plist.add(pvo); } model.addAttribute("plist",
		 * plist);
		 */
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
		int mno1 = Integer.parseInt(mno);
		int mpoint1 = Integer.parseInt(mpoint);
		MemberVO mvo = new MemberVO(mno1, mpoint1);
		int totalMpoint = 0;
		log.info(">>> cnl : " + cno);
		log.info(">>> mnl : " + mno);
		if (osv.insertOrder(ovo) > 0) {
			msv.addmpoint(mvo);
			totalMpoint = msv.getmpoint(mno1);
			if (cno != "") {
				String[] cArr = cno.split(",");
				log.info("cArr.length : " + cArr.length);
				for (int i = 0; i < cArr.length; i++) {
					log.info(">>>" + cArr[i]);
					int cno1 = Integer.parseInt(cArr[i]);
					csv.delCart(cno1);
				}
			}
		}
		model.addAttribute("mpoint", mpoint);
		model.addAttribute("totalMpoint", totalMpoint);
		return "redirect:/order/ofinal";
	}
}
