package com.tj.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1;
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
		try {
			j = scanner.nextInt(); // InputMismatchException
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j)); // ArithmeticException		
		}catch(ArithmeticException e) { // catch절이 여러개인 경우 자식단을 위쪽에 써준다. 부모단(Exception)을 위에 놓으면 위에만 걸린다.
			System.out.println(e.getMessage());
			System.out.println("0으로 나눌 수 없어 우회합니다.");
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("문자를 넣어서 자동으로 1로 바꿉니다.");
		}			
			System.out.println("i + j = "+(i+j));
			System.out.println("i - j = "+(i-j));
			System.out.println("DONE");
			scanner.close();
		
	}
}
