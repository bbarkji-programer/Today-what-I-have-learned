package com.tj.ex01_store;

public class Store2 implements HeadQuarterStore {

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
	@Override
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	@Override
	public void sundai() {
		System.out.println("순대국 5,000원");
	}
	public String getStr() {
		return str;
	}
}
