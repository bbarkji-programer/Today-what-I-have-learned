package com.tj.ex01_store;

public class Store2 implements HeadQuarterStore {

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
	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
	}
	@Override
	public void sundai() {
		System.out.println("���뱹 5,000��");
	}
	public String getStr() {
		return str;
	}
}
