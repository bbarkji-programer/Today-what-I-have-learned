package com.tj.question;

import java.util.Scanner;

// 나이를 입력받아 입력받은 나이가 65세 이상일 때 "경로우대" 출력, 아니면 "일반"을 출력
public class Op_q04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("나이를 입력 해주세요.(예: 50)");
		int age = scanner.nextInt();
		System.out.println((age >= 65) ? "경로우대" : "일반");
		
		scanner.close();
	}
}
