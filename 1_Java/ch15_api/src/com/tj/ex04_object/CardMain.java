package com.tj.ex04_object;

public class CardMain {
	public static void main(String[] args) {
		Card c1 = new Card('��', 2);
		Card c2 = new Card('��', 2);
		Card c3 = new Card('��', 5);
		System.out.println(c1); // �׳� ��ü�� ������, toString�� �ڵ������� ȣ��ȴ�. -> Ŭ������ �ȸ��������� object�� �ִ°� �ҷ���
		System.out.println(c2);
		System.out.println(c3);
		// �����Ͻ� ī��� �� 2
		// �����Ͻ� ī��� �� 2
		// �����Ͻ� ī��� �� 5
		System.out.println("c1�� c2�� ���� ī��? "+c1.equals(c2));
		// true
		System.out.println("c1�� c2�� ���� ī��? "+c1.equals(c3));
		// false
	}
}
