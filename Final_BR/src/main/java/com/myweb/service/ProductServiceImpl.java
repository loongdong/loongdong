package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;
import com.myweb.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Inject
	ProductDAO pdao;
	
	@Override
	public int register(ProductVO pvo) {
		return pdao.insertProduct(pvo);
	}

	@Override
	public List<ProductVO> getList() {
		return pdao.selectList();
	}

	@Override
	public List<ProductVO> getcateList(Criterion cri) {
		return pdao.selectcateList(cri);
	}

	@Override
	public List<ProductVO> getrankList() {
		return pdao.selectrankList();
	}

	@Override
	public int getTotalCount(String category) {
		return pdao.selectTotal(category);
	}

	@Override
	public ProductVO getProduct(int pno) {
		return pdao.selectProduct(pno);
	}

	@Override
	public List<ProductVO> getRcList(String recommend) {
		return pdao.selectRecommend(recommend);
	}

	@Override
	public ProductVO getMaterial(String pname) {
		return pdao.selectMaterial(pname);
	}

	//0715 추가부분~~
	@Override
	public ProductVO getpdetail(int pno) {
		return pdao.getpdetail(pno);
	}

	@Override
	public int getPrice(String pname) {
		return pdao.getprice(pname);
	}

}
