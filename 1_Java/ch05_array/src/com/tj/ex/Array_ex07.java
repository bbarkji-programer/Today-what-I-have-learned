package com.tj.ex;

// 오늘의 문제1) 배열에 담긴 값을 더하는 프로그램을 작성(배열값 누적합 출력)
// int[] arr = {10,20,30,40,50} 
public class Array_ex07 {
	public static void main(String[] args) {

//		int a = 10;
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110 }; // arr 이란 주소의 방이 할당되고, 그 주소에 숫자가 있는 것
		int tot = 0; // 누적변수

		for (int idx = 0; idx < arr.length; idx++) {
			tot += arr[idx];
		}
		System.out.println(tot);

	}
}
