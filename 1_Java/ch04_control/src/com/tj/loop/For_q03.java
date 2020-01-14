package com.tj.loop;

import java.util.Scanner;

// 사용자로부터 원하는 단수의 구구단을 출력하자.
public class For_q03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("구구단을 외우자. 구구단을 외우자. 몇 단? ");

		int num = scanner.nextInt(); // 원하는 숫자를 받음

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num * i);

		}
		scanner.close();
	}
}
