package com.tj.condition;

import java.util.Scanner;

// �� ���� �Է� �޾� �� ��° ���� �� ū�� �׸��� �� ū ���� ���

public class If_ex03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù ��° ���� �Է��ϼ���.");
		int num1 = scanner.nextInt();
		System.out.print("�� ��° ���� �Է��ϼ���.");
		int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("ù ��° �Է��� ("+num1+")�� �� Ů�ϴ�.");
		}else if(num1<num2) {
			System.out.println("�� ��° �Է��� ("+num2+")�� �� Ů�ϴ�.");
		}else {
			System.out.println("���� ���� �� �� �Է��ϼ̽��ϴ�.");
		} //if
		scanner.close();

	} //main

} //class
