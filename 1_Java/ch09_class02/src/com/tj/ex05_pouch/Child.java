package com.tj.ex05_pouch;

public class Child {
	static Pouch pouch = new Pouch();
	private String name;
	public Child(String name) { // main �Լ����� Child first = new Child("ù° �浿��");
		this.name = name;
	}
	public void takeMoney(int money) {
		if(Pouch.money>=money) {
			Pouch.money = Pouch.money - money;
			System.out.println(name+"�� "+money+"�� �޾ư��� ������ "+Pouch.money+"���Ҵ�.");
		}else {
			System.out.println(money+"�� ���� ������. ���� ������ ���� ���ڸ���.");
		}
	}
}
