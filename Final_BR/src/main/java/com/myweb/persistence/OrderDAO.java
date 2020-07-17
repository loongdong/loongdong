package com.myweb.persistence;

import com.myweb.domain.OrderVO;

public interface OrderDAO {
	public int insertOrder(OrderVO ovo);
	public int deleteOrder(int ono);
}
