package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.OrderVO;

public interface OrderDAO {
	public int insertOrder(OrderVO ovo);
	public int deleteOrder(int ono);
	public List<OrderVO> getPresentList(String receiver_id);
	public List<OrderVO> getbuyList(int mno);
}
