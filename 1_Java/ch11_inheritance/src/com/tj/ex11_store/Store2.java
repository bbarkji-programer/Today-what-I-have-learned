package com.tj.ex11_store;

public class Store2 extends HeadQuarterStore {

	private String str = "[���а� 2ȣ��]";
	
	@Override
	public void budai() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("����� ����!!");
	}
	public String getStr() {
		return str;
	}
}
