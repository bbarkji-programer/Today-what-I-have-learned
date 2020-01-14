package com.tj.ex02;

public class Main {

		public static void main(String[] args) {
			
			System.out.println("1. 객체변수의 타입 다형성");
			S s1 = new C();
			s1.method();
			C c1 = new C();
			c1.method();
			
			System.out.println("2. 오버라이딩 다형성");
			S s2 = new S();
			s1.method(); // C의 method() 2. 오버라이딩
			s2.method(); // S의 method()
			
			System.out.println("3. 오버로딩 다형성");
			s2.method();
			s2.method(10);
		}
}
