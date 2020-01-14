package com.tj.ex;

// 일반for vs. 확장for
// 배열 모든 방의 값을 10% 인상
public class Array_ex08 {
	public static void main(String[] args) {

		int[] arr = { 10, 20, 30 };

		// 일반형
		for (int idx = 0; idx < arr.length; idx++) {
			arr[idx] = (int) (arr[idx] * 1.1); // 배열 모든 방을 10% 인상
		}
		arrayPrint(arr); // arr 배열 출력해~

		// 확장형 -> 배열 안의 값을 수정해야 할때는 수정이 안된다. (단순 출력만 가능)
		for (int temp : arr) {
			temp = temp * 2; // 임시 파일을 수정한 거지 arr이 수정된 것이 아니니까.
		}
		arrayPrint(arr);

	}// main
	private static void arrayPrint(int[] array) { // 배열을 받아서 출력하겠다는 메소드
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println(array[idx]);
		}
	}// array
}// class