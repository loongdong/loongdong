package com.myweb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.CartDTO;
import com.myweb.domain.CartVO;
import com.myweb.domain.Criterion;

public interface CartService {
	
	public int addCart(CartVO cvo);
	public int delCart(int cno);
	public CartDTO getList(Criterion cri, int mno);
	public int getTotalCount(Criterion cri);
	public String getTest(int price);
	public int chkDuple(CartVO cvo);
}
