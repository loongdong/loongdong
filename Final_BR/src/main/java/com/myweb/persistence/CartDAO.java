package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.CartDTO;
import com.myweb.domain.CartVO;
import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

public interface CartDAO {

	public int insertCart(CartVO cvo);

	public int deleteCart(int cno);

	public List<CartVO> cartList(Criterion cri, int mno);
	
	public String getTest(int price);

	public int selectTotal(int mno);

	public int chkDuple(CartVO cvo);

}
