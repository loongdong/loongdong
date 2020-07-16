package com.myweb.service;

import com.myweb.domain.OrderVO;

public interface OrderService {
	
	public int insertOrder(OrderVO ovo);
	public int deleteOrder(int ono);
	public int getbuyList(int mno);
	public int getpresentList(String mid);
	public int modifyOrder(OrderVO ovo);
	

}
