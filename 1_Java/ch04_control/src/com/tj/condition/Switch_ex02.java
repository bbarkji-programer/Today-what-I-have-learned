package com.tj.condition;

import java.util.Scanner;

// 점수 입력 받아서 학점을 출력해보잣~ (if, switch문)
// switch 사용

public class Switch_ex02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");

		int score = scanner.nextInt(); // 정수값만 받아온다는 의미이다. nextInt()
		int temp = score == 100 ? score - 1 : score;
		// score가 100점이면, temp가 99 <- 100점을 A학점에 포함시키기 위한 조작 
		// (*case10 으로 아래에 추가만 하는 경우 102, 105 등의 문제가 생긴다.)

		switch (temp / 10) {
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("F학점");
			break;
		default:
			System.out.println("유효하지 않은 점수입니다.");
		}
		scanner.close();
	}
}
