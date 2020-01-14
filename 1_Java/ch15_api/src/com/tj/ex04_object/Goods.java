package com.tj.ex04_object;

public class Goods {

	private String goodsCode; // ��ǰ�ڵ�
	private String goodsName; // ��ǰ��
	private int goodsPrice; // ��ǰ����
	private int stock; // ������

	// Goods g = new Goods("a01","�����", 1500, 10); 
	public Goods(String goodsCode, String goodsName, int goodsPrice, int stock) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return goodsName+"("+goodsCode+") : "+goodsPrice+"��. ��� "+stock+"��";
	}
	
}
