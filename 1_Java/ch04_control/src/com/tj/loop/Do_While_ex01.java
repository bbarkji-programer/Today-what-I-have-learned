package com.tj.loop;

import java.util.Scanner;

// ¦���� �Է��� �� ���� ����ڷκ��� ���ڸ� �޴´�.
public class Do_While_ex01 {
	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		int num;
//		do {
//			System.out.println("¦���� �Է����ּ���. : ");
//			num = scanner.nextInt();
//		} while (num % 2 != 0);
//		System.out.println(num+" ¦���� �� �Է��ϼ̳׿�*^^*");
//		scanner.close();

		Scanner scanner = new Scanner(System.in);

		int num;

		do {
			System.out.println("¦���� �Է����ּ���. : ");
			num = scanner.nextInt();
		} while (num % 2 != 0);
		System.out.println("¦�� " + num + " �� �Է��ϼ̱���.");

		scanner.close();
	}
}
