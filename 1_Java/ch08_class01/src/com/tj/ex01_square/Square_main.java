package com.tj.ex01_square;
public class Square_main {
	public static void main(String[] args) {
		Square s1 = new Square(); 
		s1.setSide(5);
		Square s2 = new Square(7);
		s2.setSide(10);
		System.out.println(s1.getSide()+"������ Square ����: "+s1.area());
		System.out.println(s2.getSide()+"������ Square ����: "+s2.area());
    }
}
