package com.tj.ex01_store;

public class Store3 extends HeadQuarterStore {

	private String str = "[���ǰ� 3ȣ��]";
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void budai() {
		System.out.println("�δ�� 7,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 7,000��");
	}
	@Override
	public void sundai() {
		System.out.println("���뱹 6,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("����� 1,000��");
	}
	@Override
	public String getStr() {
		return str;
	}
}
