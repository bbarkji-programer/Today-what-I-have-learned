package com.tj.ex05_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�ּҸ� �Է��ϼ���.");
		String address = scanner.nextLine();
		System.out.println("�Է��� �ּҴ� "+address);
		
		System.out.print("�̸��� �Է��ϼ���.");
		String name = scanner.next();
		System.out.println("�Է��� �̸��� "+name);
		
		System.out.print("������ �Է��ϼ���.");
		int i = scanner.nextInt();
		System.out.println("�Է��� ������ "+i);
		
		System.out.println("-------------��-------------");
		scanner.close();
	}
}
