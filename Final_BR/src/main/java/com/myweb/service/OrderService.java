package com.myweb.service;

import java.util.List;

import com.myweb.domain.OrderVO;

public interface OrderService {
	
	public int insertOrder(OrderVO ovo);
	public int deleteOrder(int ono);
	public List<OrderVO> getbuyList(int mno);
	public List<OrderVO> getpresentList(String receiver_id);
	public int modifyOrder(OrderVO ovo);
	public int ordchk(int ono);
	

}
