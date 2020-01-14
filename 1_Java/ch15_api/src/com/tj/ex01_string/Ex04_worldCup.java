package com.tj.ex01_string;

public class Ex04_worldCup {

	public static void main(String[] args) {
		
		String str = "2002 WorldCup Korea";
		System.out.println("정상 문자열: "+str);
		System.out.print("문자열 뒤집기: ");
			for(int i = str.length()-1 ; i>=0 ; i--) {
				System.out.print(str.charAt(i));
			}
		System.out.println();
		System.out.print("짝수번째 문자열: ");
			for(int i = 1 ; i < str.length(); i++) {
				if(i%2 !=0) {
				System.out.print(str.charAt(i));
			}else {
				System.out.print(' ');
			}
		}
	}
}
