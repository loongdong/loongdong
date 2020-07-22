package com.myweb.ctrl;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.Criterion;
import com.myweb.domain.PagingVO;
import com.myweb.domain.ProductVO;
import com.myweb.service.ProductService;
import com.myweb.service.ReviewService;
import com.myweb.util.FileProcessor;

@Controller
@RequestMapping("/product/*")
public class ProductCtrl {
	private static Logger log = LoggerFactory.getLogger(ProductCtrl.class);

	@Inject
	ProductService psv;

	@Inject
	ReviewService rsv;

	@Inject
	FileProcessor fp;

	@GetMapping("/cart")
	public void cart() {
	}

	@GetMapping("/category_list")
	public void cateList(@RequestParam("category") String category, Model model, Criterion cri) {
		if (category.equals("icecone")) {
			model.addAttribute("rankList", psv.getrankList());
		}
		cri.setCategory(category);
		int totalCount = psv.getTotalCount(category);
		String[] cate = { "icecone", "cake", "drink", "coffee", "dessert" };
		model.addAttribute("cate", cate);
		model.addAttribute("pList", psv.getcateList(cri));
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	}

	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("pList", psv.getList());
	}

	@GetMapping("/detail")
	public void detail(@RequestParam("pno") int pno, Model model, @ModelAttribute("cri") Criterion cri) {
		model.addAttribute("pvo", psv.getProduct(pno));
		ProductVO pvo = psv.getProduct(pno);
		String recommend = pvo.getRecommend();
		String mate = pvo.getMaterial();
		if (mate != null) {
			String material[] = mate.split(",");
			ArrayList<ProductVO> pvoList = new ArrayList<>();
			for (int j = 0; j < material.length; j++) {
				log.info(">>> check2 material : " + material[j]);
				pvoList.add(psv.getMaterial(material[j]));
			}
			model.addAttribute("meList", pvoList);
		}
		if (recommend != null) {
			model.addAttribute("rcList", psv.getRcList(recommend));
		}

		// 0722 오후 추가부분 리뷰리스트 가지고옴
		if (rsv.getRvList(pno) == null) {
			model.addAttribute("rvList", "리뷰가 없습니다");
		}else {
			model.addAttribute("rvList", rsv.getRvList(pno));
		}

	}

	@PostMapping("/write")
	public String write(MultipartHttpServletRequest multiReq, RedirectAttributes reAttr) {
		int isln = psv.register(fp.fileSave(multiReq));
		if (isln > 0) {
			reAttr.addFlashAttribute("pSign", "상품입력이 완료되었습니다.");
		}
		return "redirect:/";
	}

	@GetMapping("/write")
	public void write() {
	}

}
