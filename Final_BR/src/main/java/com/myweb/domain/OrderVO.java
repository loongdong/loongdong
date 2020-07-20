package com.myweb.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderVO {

	private int ono;
	private int mno;
	private String pname;
	private String receiver_id;
	private String memo;
	private int total;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date odate;
	private int status;
	private String amount;
	private int price;

	public OrderVO() {
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public OrderVO(int mno, String pname, String receiver_id, String memo, int total) {
		this.mno = mno;
		this.pname = pname;
		this.receiver_id = receiver_id;
		this.memo = memo;
		this.total = total;
	}

	public OrderVO(int ono, int mno, String pname, String receiver_id, String amount, String memo, int total,
			int status) {
		this(mno, pname, receiver_id, memo, total);
		this.ono = ono;
		this.status = status;
		this.amount = amount;
	}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
