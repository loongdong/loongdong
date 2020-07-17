package com.myweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.domain.OrderVO;
import com.myweb.persistence.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Inject
	OrderDAO odao;

	@Override
	public int insertOrder(OrderVO ovo) {
		return odao.insertOrder(ovo);
	}

	@Override
	public int deleteOrder(int ono) {
		return odao.deleteOrder(ono);
	}

	@Override
	public int getbuyList(int mno) {
		return 0;
	}

	@Override
	public int getpresentList(String mid) {
		return 0;
	}

	@Override
	public int modifyOrder(OrderVO ovo) {
		return 0;
	}
}
