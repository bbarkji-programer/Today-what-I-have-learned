package com.tj.question;

import java.util.Scanner;

// 주민번호 7번째 자리수를 입력받아 여자인지 남자인지 출력하세요 1이나 3은 남자를 출력, 2나 4는 여자를 그 외의 숫자를 입력하면 떼끼를 출력하도록 구현하세요.

public class Op_q05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("주민등록번호 일곱번 째 숫자를 입력해주세요.(예: 1 or 2 or 3 or 4)");
		int num = scanner.nextInt();
		String result = (num==1 || num==3) ? "남자" : (num==2 || num==4) ? "여자" : "잘못 입력하셨습니다.";
		System.out.println(result);
		scanner.close();
	}
}
