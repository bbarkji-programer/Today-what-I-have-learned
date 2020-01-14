package com.tj.ex04;

public class MainClass {
	public static void main(String[] args) {
		S a = new A();
		S b = new B();
		S c = new C();
	S[] objArr = {a, b, c}; 
	for(S obj : objArr) {
		System.out.println(obj.s);
	}
	}
}
