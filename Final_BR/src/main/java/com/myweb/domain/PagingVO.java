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

}
