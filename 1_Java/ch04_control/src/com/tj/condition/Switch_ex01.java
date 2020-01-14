package com.tj.condition;

import java.util.Scanner;

// 점수 입력 받아서 학점을 출력해보잣~ (if, switch문) 
// IF문 사용

public class Switch_ex01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = scanner.nextInt(); // 정수값만 받아온다는 의미이다. nextInt()

		if (90 <= score && score <= 100) { // 90<=score<=100
			System.out.println("A학점");
		} else if (80 <= score && score < 90) {
			System.out.println("B학점");
		} else if (70 <= score && score < 80) {
			System.out.println("C학점");
		} else if (60 <= score && score < 70) {
			System.out.println("D학점");
		} else if (0 <= score && score < 60) {
			System.out.println("F학점");
		} else {
			System.out.println("유효하지 않은 점수입니다.");
		}
		scanner.close();
	}
}
