package com.myweb.service;

import java.util.List;

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
	public List<OrderVO> getbuyList(int mno) {
		return odao.getbuyList(mno);
	}

	@Override
	public List<OrderVO> getpresentList(String receiver_id) {
		return odao.getPresentList(receiver_id);
	}

	@Override
	public int modifyOrder(OrderVO ovo) {
		return 0;
	}
}
