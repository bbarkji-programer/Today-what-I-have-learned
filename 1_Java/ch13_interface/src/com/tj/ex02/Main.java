package com.tj.ex02;

public class Main {

		public static void main(String[] args) {
			
			System.out.println("1. ��ü������ Ÿ�� ������");
			S s1 = new C();
			s1.method();
			C c1 = new C();
			c1.method();
			
			System.out.println("2. �������̵� ������");
			S s2 = new S();
			s1.method(); // C�� method() 2. �������̵�
			s2.method(); // S�� method()
			
			System.out.println("3. �����ε� ������");
			s2.method();
			s2.method(10);
		}
}
