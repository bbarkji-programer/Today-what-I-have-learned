package com.tj.ex11_store;

public class Store2 extends HeadQuarterStore {

	private String str = "[대학가 2호점]";
	
	@Override
	public void budai() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void gongibab() {
		System.out.println("공기밥 무료!!");
	}
	public String getStr() {
		return str;
	}
}
