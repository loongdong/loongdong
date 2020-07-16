package com.myweb.domain;

import java.util.Date;

public class OrderVO {

	private int ono;
	private int mno;
	private String pname;
	private String receiver_id;
	private String memo;
	private int total;
	private Date odate;
	private int status;

	public OrderVO() {
	}

	public OrderVO(int mno, String pname, String receiver_id, String memo, int total) {
		this.mno = mno;
		this.pname = pname;
		this.receiver_id = receiver_id;
		this.memo = memo;
		this.total = total;
	}

	public OrderVO(int ono, int mno, String pname, String receiver_id, String memo, int total, int status) {
		this(mno, pname, receiver_id, memo, total);
		this.ono = ono;
		this.status = status;
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
