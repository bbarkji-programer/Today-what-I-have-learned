package com.tj.ex07_this;

public class Friend {

	private String name;
	private String phone;
	
	public Friend() {
		System.out.println("�Ű����� 0�� ¥��");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("�Ű����� 1�� ¥��");
	}
	public Friend(String name, String phone) {
		// this. : �� ��ü��
		// this() : �� ��ü�� �������Լ�
		this(name);
//		this.name = name;
		this.phone = phone;
		System.out.println("�Ű����� 2�� ¥��");
	}
	public String infoString() {
		return name+" : "+phone;
	}
	
}
