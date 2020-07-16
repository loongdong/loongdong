package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.CartDTO;
import com.myweb.domain.CartVO;
import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;
import com.myweb.persistence.CartDAO;

@Service
public class CartServiceImpl implements CartService {
	private static Logger log = LoggerFactory.getLogger(CartServiceImpl.class);

	@Inject
	CartDAO cdao;
	
	@Override
	public int addCart(CartVO cvo) {
		return cdao.insertCart(cvo);
	}
	
	

	@Override
	public int delCart(int cno) {
		return cdao.deleteCart(cno);
	}

	@Override
	public CartDTO getList(Criterion cri, int mno) {
		
		List<CartVO> list = cdao.cartList(cri, mno);
		int cartCnt = cdao.selectTotal(mno);
		CartDTO cdto = new CartDTO(cartCnt,list);
		return cdto;
		
	}

	@Override
	public int getTotalCount(Criterion cri) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getTest(int price) {
		return cdao.getTest(price);
	}

	@Override
	public int chkDuple(CartVO cvo) {
		return cdao.chkDuple(cvo);
	}
	
}
