package com.tj.ex05_pouch;

public class Pouch_main {
	public static void main(String[] args) {
		
		Child first = new Child("ù°");
		Child second = new Child("��°");
		Child third = new Child("��°");		
		
		System.out.println("���� ���� ��: "+Pouch.money);		
		first.takeMoney(100);
		System.out.println("���� ���� ��: "+Pouch.money);
		second.takeMoney(100);
		System.out.println("���� ���� ��: "+Pouch.money);
		third.takeMoney(100);		

	}
}
