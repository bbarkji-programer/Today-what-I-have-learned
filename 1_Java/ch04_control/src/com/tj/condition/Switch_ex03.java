package com.tj.condition;

import java.util.Scanner;

// 키보드로부터 정수값을 입력받아 그 입력한 값이 짝수인지 홀수인지 출력해봐유~
// switch문 이용해유~

public class Switch_ex03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자(정수)를 입력해주세요 : ");

		int num = scanner.nextInt();
		switch (num % 2) {
		case 0:
			System.out.println("짝수를 입력하셨네용~");
			break;
		default:
			System.out.println("홀수를 입력하셨군용~");
		}
		scanner.close();
	}
}
