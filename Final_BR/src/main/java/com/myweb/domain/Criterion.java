package com.myweb.domain;


public class Criterion {
	
	private int amount;
	private int pageNum;
	
	private String type;
	private String keyword; //검색용
	private String find;
	private String searchword;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Criterion() {
		this(1,20);  //리스트 변경 (1,15)
	}
	public int getAmount() {
		return amount;
	}
	public Criterion(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	
}


