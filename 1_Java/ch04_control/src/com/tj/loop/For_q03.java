package com.tj.loop;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �ܼ��� �������� �������.
public class For_q03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("�������� �ܿ���. �������� �ܿ���. �� ��? ");

		int num = scanner.nextInt(); // ���ϴ� ���ڸ� ����

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num * i);

		}
		scanner.close();
	}
}
