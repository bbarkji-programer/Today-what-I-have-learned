package com.tj.ex01_string;
// String 수정이 빈번한 경우
public class Ex10_StringBuilder {

	public static void main(String[] args) {
		
		StringBuilder strBuilder = new StringBuilder("abc");
		StringBuffer strBuffer = new StringBuffer("abc");
		
		strBuilder.append("def"); // abcdef
		System.out.println(strBuilder);
		
		strBuilder.insert(3, "AAA"); //abcAAAdef
		System.out.println(strBuilder);
		
		strBuilder.delete(3, 5); // (i,j) i부터 j앞까지 삭제 -> abcAdef
		System.out.println(strBuilder);
		
		strBuilder.deleteCharAt(3); // 3번째만 지우고 싶어 -> abcdef
		System.out.println(strBuilder);
		
		int capacitySize = strBuilder.capacity(); // 빌더의 가용크기
		System.out.println("빌더의 가용크기 : "+capacitySize);
		
		strBuilder.append("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.out.println(strBuilder);
		capacitySize = strBuilder.capacity();
		System.out.println("현재 빌더의 가용크기 : "+capacitySize);
	}
}
