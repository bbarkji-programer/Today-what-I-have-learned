package com.tj.question;

import java.util.Scanner;

// �ֹι�ȣ 7��° �ڸ����� �Է¹޾� �������� �������� ����ϼ��� 1�̳� 3�� ���ڸ� ���, 2�� 4�� ���ڸ� �� ���� ���ڸ� �Է��ϸ� ������ ����ϵ��� �����ϼ���.

public class Op_q05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�ֹε�Ϲ�ȣ �ϰ��� ° ���ڸ� �Է����ּ���.(��: 1 or 2 or 3 or 4)");
		int num = scanner.nextInt();
		String result = (num==1 || num==3) ? "����" : (num==2 || num==4) ? "����" : "�߸� �Է��ϼ̽��ϴ�.";
		System.out.println(result);
		scanner.close();
	}
}
