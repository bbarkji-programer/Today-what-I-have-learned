package com.tj.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		do {
			try {
				System.out.print("첫 번재 정수 i는? ");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("문자 말고 정수(숫자)를 넣어주세요.");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}
		}while(true);
		System.out.print("두 번째 정수 j는? ");
			j = scanner.nextInt();
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i * j = "+(i*j));
			
			try {
				System.out.println("i / j = "+(i/j));
			}catch(ArithmeticException e) { // 예외 상황으로 생긴 객체를 e에 . ArithmeticException -> Exception 가능
				//e.printStackTrace(); // e.getMessage()보다 자세하게 뿌려줌.
				System.out.println(e.getMessage()); // by zero
				System.out.println("0으로 나눌 수 없어 우회합니다.");		
			}
			
			System.out.println("i + j = "+(i+j));
			System.out.println("i - j = "+(i-j));
			System.out.println("DONE");
			scanner.close();
		
	}
}
