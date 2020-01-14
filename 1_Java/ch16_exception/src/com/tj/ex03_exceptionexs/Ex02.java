package com.tj.ex03_exceptionexs;
// java.lang.NullPointerException
public class Ex02 {
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(str.indexOf('z')); // 없으면  -1 리턴
		str = null;
		System.out.println(str.indexOf('z')); 
	}
}
