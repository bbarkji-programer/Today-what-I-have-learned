package com.tj.condition;

import java.util.Scanner;

// ���������� �� �ϳ��� ���� �� ���� ����ϼ���~

public class If_q04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2) �� �ϳ��� �Է����ּ���. : ");
		int you = scanner.nextInt(); // 0,1,2
		if (you == 0) {
			System.out.println("������ ���̱���.");
		} else if (you == 1) {
			System.out.println("������ ���̱���.");
		} else if (you == 2) {
			System.out.println("���� ���̱���.");
		} else {
			System.out.println("��ȿ���� ���� ���Դϴ�.");
		}//if
		scanner.close();
	}//main
}//class
