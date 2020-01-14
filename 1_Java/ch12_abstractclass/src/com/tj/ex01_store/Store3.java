package com.tj.ex01_store;

public class Store3 extends HeadQuarterStore {

	private String str = "[Áõ±Ç°¡ 3È£Á¡]";
	
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 6,000¿ø");
	}
	@Override
	public void budai() {
		System.out.println("ºÎ´ëÂî°³ 7,000¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä 7,000¿ø");
	}
	@Override
	public void sundai() {
		System.out.println("¼ø´ë±¹ 6,000¿ø");
	}
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä 1,000¿ø");
	}
	@Override
	public String getStr() {
		return str;
	}
}
