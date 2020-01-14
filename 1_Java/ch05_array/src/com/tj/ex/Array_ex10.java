package com.tj.ex;

// 오늘의 문제3) 76,45,34,89,100,50,90,92
// 8개의 값을 1차원 배열로 초기화 하고 값에 총합, 평균, 최대값, 최소값을 출력하쇼.
public class Array_ex10 {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int tot = 0; // 총합
		double avg; // 평균
		int max = -9999; // 최대값
		int min = 9999; // 최소값
		for (int temp : arr) {
			tot += temp; // 누적
			if (max < temp) {
				max = temp;
			} // 최대값처리
			if (min > temp) {
				min = temp;
			} // 최소값처리
		} // for
		avg = tot / arr.length;
		System.out.println("총합: " + tot + ", 평균: " + avg);
		System.out.println("최대값: " + max + ", 최소값: " + min);// 출력
	}// main
}// class
