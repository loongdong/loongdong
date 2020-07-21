package com.myweb.domain;

public class PagingVO {

	private int totalCount; // 총 게시글 수 
	private int beginPagingNum; //페이징라인의 가장 앞번호
	private int endPagingNum; //페이징라인의 가장 뒷번호
	private boolean prev, next; //앞으로, 다음버튼생성여부
	private Criterion cri; //페이징 구현

	public PagingVO() {
	}
	
	
	public PagingVO(int totalCount, Criterion cri) {
		this.totalCount = totalCount;
		this.cri = cri;
		this.endPagingNum = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.beginPagingNum = this.endPagingNum-9;
		
		int realEndPagingNum =(int)(Math.ceil((totalCount*1.0)/cri.getAmount()));
		
		if(this.endPagingNum>=realEndPagingNum) {
			this.endPagingNum = realEndPagingNum;
		}
		this.prev = beginPagingNum >1;
		this.next = this.endPagingNum < realEndPagingNum;
		
		
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getBeginPagingNum() {
		return beginPagingNum;
	}


	public void setBeginPagingNum(int beginPagingNum) {
		this.beginPagingNum = beginPagingNum;
	}


	public int getEndPagingNum() {
		return endPagingNum;
	}


	public void setEndPagingNum(int endPagingNum) {
		this.endPagingNum = endPagingNum;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public Criterion getCri() {
		return cri;
	}


	public void setCri(Criterion cri) {
		this.cri = cri;
	}

}
