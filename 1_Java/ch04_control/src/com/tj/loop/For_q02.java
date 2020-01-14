package com.tj.loop;

// 1~10까지 숫자 중 짝수(또는 홀수)의 합을 구해보자.
public class For_q02 {
	public static void main(String[] args) {
		int tot = 0; // 누적 합의 변수 셋팅
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				tot = tot + i;
			}
		}
		System.out.println("1~10까지의 짝수의 합은 " + tot);
	}
}
