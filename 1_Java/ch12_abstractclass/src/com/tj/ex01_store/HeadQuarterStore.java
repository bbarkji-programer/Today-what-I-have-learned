package com.tj.ex01_store;

public abstract class HeadQuarterStore {
	
	private String str = "[본사]";
	
	// 추상 메소드 : 메소드 선언부만 있는 메소드(구현부는 없음)
	public abstract void kimchi();
	public abstract void budai();
	public abstract void bibib();
	public abstract void sundai();
	public abstract void gongibab();
	
	public String getStr() {
		return str;
	}
}
