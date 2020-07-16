package com.myweb.domain;

public class ProductVO {
	private int pno;
	private String pname;
	private String engpname;
	private String category;
	private String pcontent;
	private String hashtag;
	private String material;
	private String recommend;
	private int sellcnt;
	private int price;
	private String pimg;
	private String regd8;
	private int rn;
	
	public ProductVO() {	}
	
	public ProductVO(int pno, String pname, String engpname, String category, String pcontent, String hashtag,
			String material, String recommend, int sellcnt, int price, String pimg, String regd8) {
		this.pno = pno;
		this.pname = pname;
		this.engpname = engpname;
		this.category = category;
		this.pcontent = pcontent;
		this.hashtag = hashtag;
		this.material = material;
		this.recommend = recommend;
		this.sellcnt = sellcnt;
		this.price = price;
		this.pimg = pimg;
		this.regd8 = regd8;
	}

	public ProductVO(String pname, String engpname, String category, String pcontent, String hashtag, String material,
			String recommend, int price, String pimg, String regd8) {
		this.pname = pname;
		this.engpname = engpname;
		this.category = category;
		this.pcontent = pcontent;
		this.hashtag = hashtag;
		this.material = material;
		this.recommend = recommend;
		this.price = price;
		this.pimg = pimg;
		this.regd8 = regd8;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEngpname() {
		return engpname;
	}

	public void setEngpname(String engpname) {
		this.engpname = engpname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public int getSellcnt() {
		return sellcnt;
	}

	public void setSellcnt(int sellcnt) {
		this.sellcnt = sellcnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public String getRegd8() {
		return regd8;
	}

	public void setRegd8(String regd8) {
		this.regd8 = regd8;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}
	

}
