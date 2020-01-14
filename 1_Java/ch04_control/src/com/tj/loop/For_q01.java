package com.tj.loop;

// 1~10까지의 곱을 구해보자.
public class For_q01 {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 1; i <= 10; i++) {
			num *= i;
			if (i == 10) {
				System.out.println("1~10까지의 곱은 "+num);
			}
		}
	}
}
