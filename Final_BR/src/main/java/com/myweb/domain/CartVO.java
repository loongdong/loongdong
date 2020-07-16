package com.myweb.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartVO {
	private static Logger log = LoggerFactory.getLogger(CartVO.class);
	
	private int cno;
	private int mno;
	private int pno;
	private String pname;
	private String pimg;
	private int price;
	private String category;
	
	public CartVO() {}
	
	public CartVO(int cno, int mno, int pno, String pname, String pimg, int price, String category) {
		this.cno = cno;
		this.mno = mno;
		this.pno = pno;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.category = category;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	//삽입용
	public CartVO(int mno, int pno) {
		this.mno = mno;
		this.pno = pno;
	}
	
	public CartVO(int cno) {
		this.cno = cno;
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	
}
