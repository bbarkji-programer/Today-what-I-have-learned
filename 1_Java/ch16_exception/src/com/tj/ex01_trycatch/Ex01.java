package com.tj.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
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
			j = scanner.nextInt();
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i * j = "+(i*j));
			
			try {
				System.out.println("i / j = "+(i/j));
			}catch(ArithmeticException e) { // ���� ��Ȳ���� ���� ��ü�� e�� . ArithmeticException -> Exception ����
				//e.printStackTrace(); // e.getMessage()���� �ڼ��ϰ� �ѷ���.
				System.out.println(e.getMessage()); // by zero
				System.out.println("0���� ���� �� ���� ��ȸ�մϴ�.");		
			}
			
			System.out.println("i + j = "+(i+j));
			System.out.println("i - j = "+(i-j));
			System.out.println("DONE");
			scanner.close();
		
	}
}
