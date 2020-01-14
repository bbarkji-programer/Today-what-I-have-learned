package com.tj.ex;
// 일반 for vs. 확장 for
public class Array_ex06 {
	public static void main(String[] args) {
		int[] names = {10, 20, 30}; // 객체배열
		
		//일반for문
		for(int idx = 0; idx < names.length; idx++  ) {
			System.out.println(names[idx]);
			
		}
		
		//확장for문 - 출력만 할 때
		for(int temp : names) {
			System.out.println(temp);
		}
		
	}
}
