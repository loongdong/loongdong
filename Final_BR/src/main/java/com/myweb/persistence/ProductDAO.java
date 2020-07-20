package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

public interface ProductDAO {
	public int insertProduct(ProductVO pvo);
	public List<ProductVO> selectList();
	public List<ProductVO> selectcateList(Criterion cri);
	public List<ProductVO> selectrankList();
	public int selectTotal(String category);
	
	//0715 추가부분
	public ProductVO getpdetail(int pno);
	public int getprice(String pname);
}
