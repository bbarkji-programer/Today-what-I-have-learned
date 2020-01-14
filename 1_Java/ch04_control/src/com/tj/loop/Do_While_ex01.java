package com.tj.loop;

import java.util.Scanner;

// 짝수를 입력할 때 까지 사용자로부터 숫자를 받는다.
public class Do_While_ex01 {
	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		int num;
//		do {
//			System.out.println("짝수를 입력해주세요. : ");
//			num = scanner.nextInt();
//		} while (num % 2 != 0);
//		System.out.println(num+" 짝수를 잘 입력하셨네용*^^*");
//		scanner.close();

		Scanner scanner = new Scanner(System.in);

		int num;

		do {
			System.out.println("짝수를 입력해주세요. : ");
			num = scanner.nextInt();
		} while (num % 2 != 0);
		System.out.println("짝수 " + num + " 을 입력하셨군요.");

		scanner.close();
	}
}
