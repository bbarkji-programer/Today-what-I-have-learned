package com.tj.question;

import java.util.Scanner;

// (��������2) �Է��� ���� ¦������ Ȧ������ ���
public class Op_q02 {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� ->");
		int i = scanner.nextInt();
		System.out.println(i%2==0 ? "¦���� �Է��߱���." : "Ȧ���� �Է��߱���.");
		scanner.close();
	}
}
