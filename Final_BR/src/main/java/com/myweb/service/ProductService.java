package com.myweb.service;

import java.util.List;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

public interface ProductService {
	public int register(ProductVO pvo);
	public List<ProductVO> getList();
	public List<ProductVO> getcateList(Criterion cri);
	public List<ProductVO> getrankList();
	public int getTotalCount(String category);
	
	//0715 추가부분
	
	public ProductVO getpdetail(int pno);
	
	
}
