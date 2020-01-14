package com.tj.ex;

public class Array_ex01 {
	public static void main(String[] args) {
		
//		int i = 1; // 변수 선언과 초기화
		int[] iArr = { 10, 20, 30, 40, 50, 60, 70 }; // ① 배열 선언과 동시에 초기화
		for (int idx = 0; idx < iArr.length; idx++) { // .length 는 배열의 길이
			System.out.println(iArr[idx]);
		}//for

		int[] iArr2 = new int[5]; // ② 배열 선언과 배열 메모리 할당 (값을 넣은 건 아님. 그래도 0이 자동으로 들어가있다.)
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.println(iArr2[idx]);
		}//for
		
		int[] iArr3; // ③ 배열 선언만. (공간만 확보 됨)
		iArr3 = new int[3]; // 이렇게 해야 메모리가 할당됨
		iArr3[0] = 100; // 메모리 할당을 해야, 선언(초기화) 가능
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.println(iArr3[idx]);
		}//for
		
	}//main
}//class