package com.tj.question;

import java.util.Scanner;

public class Op_q03 {
// �Է��� �� ���� �񱳿����ڸ� �̿��Ͽ�, ���� ����� true�� O, false�� X�� ����Ͻÿ�.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù �� ° �� : ");
		int num1 = scanner.nextInt();
		System.out.print("�� �� ° �� : ");
		int num2 = scanner.nextInt();
		
		boolean result = num1 == num2;
		System.out.println("num1 == num2 ��?\t" +((result==true)? "O":"X"));
		
		result = num1 != num2;
		System.out.println("num1 != num2 ��?\t" +((result==true)? "O" : "X"));
		
		result = num1 > num2;
		System.out.println("num1 > num2 ��?\t" +((result==true)? "O" : "X"));
		
		result = num1 < num2;
		System.out.println("num1 < num2 ��?\t" +((result==true)? "O" : "X"));
		
		
		
		scanner.close();
	}

}
