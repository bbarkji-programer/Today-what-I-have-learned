package com.tj.ex01_store;

public abstract class HeadQuarterStore {
	
	private String str = "[����]";
	
	// �߻� �޼ҵ� : �޼ҵ� ����θ� �ִ� �޼ҵ�(�����δ� ����)
	public abstract void kimchi();
	public abstract void budai();
	public abstract void bibib();
	public abstract void sundai();
	public abstract void gongibab();
	
	public String getStr() {
		return str;
	}
}
