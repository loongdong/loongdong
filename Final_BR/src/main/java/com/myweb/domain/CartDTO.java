package com.myweb.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartDTO {
	
	private int cartCnt; // 카트 총 갯수
	private List<CartVO> clist; //데이터베이스에서 가져온 댓글 리스트
	
	public CartDTO() {}
	public CartDTO(int cartCnt,List<CartVO> clist) {
		this.cartCnt = cartCnt;
		this.clist = clist;
	}
	public int getCartCnt() {
		return cartCnt;
	}
	public void setCmtCnt(int cartCnt) {
		this.cartCnt = cartCnt;
	}
	public List<CartVO> getClist() {
		return clist;
	}
	public void setClist(List<CartVO> clist) {
		this.clist = clist;
	}	
}
