package com.tj.ex;

// method화 - sum(1,10), evenOdd(500)
public class BeforeOOP_ex02 {
	public static void main(String[] args) { // return이 없는 메소드는 그냥 void(리턴X)
		int sum = sum(10);
		System.out.println("1부터 10까지 누적합은 " + sum + "입니다.");
//		System.out.println((sum % 2 == 0) ? "짝수입니다." : "홀수입니다.");
		System.out.println(evenOdd(sum));
		sum = sum(10, 100);
		System.out.println("10부터 100까지 누적합은 " + sum + "입니다.");
		sum = sum(10.2);
	}// main

	private static int sum(double to) {
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}

	private static int sum(int to) {
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}

	private static int sum(int from, int to) { // return 해야 하는 경우, 리턴값의 성질을 void 대신
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}// sum

	private static String evenOdd(int value) {
		String result = value % 2 == 0 ? "짝수" : "홀수";
		return result;
//		return value%2==0? "짝수":"홀수";
	}
}
