package com.tj.question;

import java.util.Scanner;

// (연습문제2) 입력한 수가 짝수인지 홀수인지 출력
public class Op_q02 {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 ->");
		int i = scanner.nextInt();
		System.out.println(i%2==0 ? "짝수를 입력했군요." : "홀수를 입력했군요.");
		scanner.close();
	}
}
