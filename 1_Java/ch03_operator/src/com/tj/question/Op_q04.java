package com.tj.question;

import java.util.Scanner;

// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� �� "��ο��" ���, �ƴϸ� "�Ϲ�"�� ���
public class Op_q04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���̸� �Է� ���ּ���.(��: 50)");
		int age = scanner.nextInt();
		System.out.println((age >= 65) ? "��ο��" : "�Ϲ�");
		
		scanner.close();
	}
}
