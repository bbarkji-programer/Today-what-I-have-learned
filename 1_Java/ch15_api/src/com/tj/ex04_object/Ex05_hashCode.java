package com.tj.ex04_object;

public class Ex05_hashCode {
	public static void main(String[] args) {
		Card c1 = new Card('��',8);
		Card c2 = new Card('��',8);
		System.out.println("c1�� c2�� ���� ī���(=���� ���̳�)? "+c1.equals(c2)); // = ���� ���̳�?
		System.out.println("c1�� c2�� �ּҰ� ����(=���� ��ü��)? "+(c1==c2)); // = ���� ��ü��?
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		
	}
}
