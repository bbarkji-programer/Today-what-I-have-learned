package com.tj.condition;

import java.util.Scanner;

// Ű����κ��� �������� �Է¹޾� �� �Է��� ���� ¦������ Ȧ������ ����غ���~
// switch�� �̿�����~

public class Switch_ex03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(����)�� �Է����ּ��� : ");

		int num = scanner.nextInt();
		switch (num % 2) {
		case 0:
			System.out.println("¦���� �Է��ϼ̳׿�~");
			break;
		default:
			System.out.println("Ȧ���� �Է��ϼ̱���~");
		}
		scanner.close();
	}
}
