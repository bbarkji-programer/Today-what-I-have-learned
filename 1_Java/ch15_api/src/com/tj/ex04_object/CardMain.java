package com.tj.ex04_object;

public class CardMain {
	public static void main(String[] args) {
		Card c1 = new Card('♥', 2);
		Card c2 = new Card('♥', 2);
		Card c3 = new Card('♣', 5);
		System.out.println(c1); // 그냥 객체만 넣으면, toString이 자동적으로 호출된다. -> 클래스에 안만들어놓으면 object에 있는걸 불러옴
		System.out.println(c2);
		System.out.println(c3);
		// 선택하신 카드는 ♥ 2
		// 선택하신 카드는 ♥ 2
		// 선택하신 카드는 ♣ 5
		System.out.println("c1과 c2는 같은 카드? "+c1.equals(c2));
		// true
		System.out.println("c1과 c2는 같은 카드? "+c1.equals(c3));
		// false
	}
}
