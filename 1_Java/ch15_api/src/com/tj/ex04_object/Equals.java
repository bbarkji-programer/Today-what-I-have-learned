package com.tj.ex04_object;

public class Equals {

	public static void main(String[] args) {
		
		Person p1 = new Person(9001082111111L);
		Person p2 = new Person(9001082111111L);
		Sawon s1 = new Sawon("a01", "홍");
		
		if(p1.equals(p2)) {
			System.out.println("같은 사람");
		}else {
			System.out.println("다른 사람");
		}
	}
}
