package com.tj.ex04_object;

public class Equals {

	public static void main(String[] args) {
		
		Person p1 = new Person(9001082111111L);
		Person p2 = new Person(9001082111111L);
		Sawon s1 = new Sawon("a01", "ȫ");
		
		if(p1.equals(p2)) {
			System.out.println("���� ���");
		}else {
			System.out.println("�ٸ� ���");
		}
	}
}
