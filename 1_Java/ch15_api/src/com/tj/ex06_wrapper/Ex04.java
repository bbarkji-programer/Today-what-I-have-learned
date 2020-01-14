package com.tj.ex06_wrapper;

public class Ex04 {
	public static void main(String[] args) {
		//"100" -> 100
		System.out.println(Integer.parseInt("100"));
		// 100 -> "100"
		System.out.println(""+100);
		System.out.println(String.valueOf(100)); // <- 있어보이는 방법
	}
}
