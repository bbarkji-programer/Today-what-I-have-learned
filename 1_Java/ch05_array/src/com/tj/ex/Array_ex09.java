package com.tj.ex;

//2차원 배열에 저장된 값의 합계를 구하시오
//int[][] arr = { {   5,  5,   5,   5,   5}, {10, 10, 10, 10, 10}, {20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};

public class Array_ex09 {
	public static void main(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, 
						{ 10, 10, 10, 10, 10 }, 
						{ 20, 20, 20, 20, 20 }, 
						{ 30, 30, 30, 30, 30 } }; // 가독성좋게
		int tot = 0; // 누적변수
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				tot += arr[i][j];
			}
		}
		System.out.println("누적합 : " +tot);
	}
}