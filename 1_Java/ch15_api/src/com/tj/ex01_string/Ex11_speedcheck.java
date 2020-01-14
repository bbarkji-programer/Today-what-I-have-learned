package com.tj.ex01_string;

public class Ex11_speedcheck {

	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis()); // 1970.01.01.0시부터 현재까지의 밀리세컨
		String str = "A";
		
		long startTime = System.currentTimeMillis();
		for(int i=0 ; i<50000 ; i++) {
			str = str + "a";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("String 5만번 수정시간: "+(endTime-startTime));
		
		StringBuffer strBuffer = new StringBuffer("A");
		startTime = System.currentTimeMillis(); // 시작시점
		for(int i=0 ; i<50000 ; i++) {
			strBuffer.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 5만번 수정 경과시간: "+(endTime-startTime));
		
		StringBuilder strBuilder = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		for(int i=0 ; i<50000 ; i++) {
			strBuilder.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 5만번 수정 경과시간: "+(endTime-startTime));
	}
}
