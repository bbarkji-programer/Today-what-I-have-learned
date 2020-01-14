package com.tj.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1;
		do {
			try {
				System.out.print("ù ���� ���� i��? ");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("���� ���� ����(����)�� �־��ּ���.");
				scanner.nextLine(); // ���۸� ����� ����
			}
		}while(true);
		System.out.print("�� ��° ���� j��? ");
		try {
			j = scanner.nextInt(); // InputMismatchException
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j)); // ArithmeticException		
		}catch(ArithmeticException e) { // catch���� �������� ��� �ڽĴ��� ���ʿ� ���ش�. �θ��(Exception)�� ���� ������ ������ �ɸ���.
			System.out.println(e.getMessage());
			System.out.println("0���� ���� �� ���� ��ȸ�մϴ�.");
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("���ڸ� �־ �ڵ����� 1�� �ٲߴϴ�.");
		}			
			System.out.println("i + j = "+(i+j));
			System.out.println("i - j = "+(i-j));
			System.out.println("DONE");
			scanner.close();
		
	}
}
