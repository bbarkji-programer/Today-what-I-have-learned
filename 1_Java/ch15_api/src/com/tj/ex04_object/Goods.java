package com.tj.ex04_object;

public class Goods {

	private String goodsCode; // 상품코드
	private String goodsName; // 상품명
	private int goodsPrice; // 상품가격
	private int stock; // 재고수량

	// Goods g = new Goods("a01","새우깡", 1500, 10); 
	public Goods(String goodsCode, String goodsName, int goodsPrice, int stock) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return goodsName+"("+goodsCode+") : "+goodsPrice+"원. 재고 "+stock+"개";
	}
	
}
