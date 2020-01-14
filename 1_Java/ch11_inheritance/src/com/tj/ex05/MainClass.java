package com.tj.ex05;

public class MainClass {
	public static void main(String[] args) {
//		Super s = new Super();
//		System.out.println(s.s);
		Child01 c1 = new Child01(10);
		System.out.println(c1.s);
		Child02 c2 = new Child02();
		System.out.println("c2.s = "+c2.s);
		GrandChild gc = new GrandChild();
		System.out.println("gc.s = "+gc.s);
		System.out.println("gc.c1 = "+gc.c1);
//		System.out.println("gc.c1 = "+gc.c2); ºÒ°¡´É
		
	}
	
}
