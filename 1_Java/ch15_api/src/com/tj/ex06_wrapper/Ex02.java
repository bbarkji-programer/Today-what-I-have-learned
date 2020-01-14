package com.tj.ex06_wrapper;

import com.tj.ex04_object.Card;

public class Ex02 {
	public static void main(String[] args) {
		Integer obj1 = 10; // Integer obj1 = new Integer(10);
		Integer obj2 = 10; // Integer obj2 = new Integer(10);
		int total = obj1+obj2;
		Card c = new Card('♥',10);
		System.out.println(c.equals(obj1));
		int i = 10;
		boolean b = true;
		Boolean bObj = true; // 사실 -> new Boolean(true); 이것임
		System.out.println(c.equals(i));
	}
}
