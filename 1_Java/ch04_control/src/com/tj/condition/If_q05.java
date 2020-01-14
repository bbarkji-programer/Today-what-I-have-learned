package com.tj.condition;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다.

public class If_q05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2) 중 하나(숫자)를 입력해주세요. : ");

		int you = scanner.nextInt(); // you가 0,1,2 중 하나 입력함.
		int com = (int) (Math.random() * 3); // com이 0,1,2 중 하나 출력됨. (아래 설명 참고)
		// 0.0 <= Math.random() < 1 의 임의(랜덤)의 실수를 발생시키는 API
		// 0.0 <= Math.random()*3 < 3 <- 이렇게 변형 해서 사용하쟈~
		// (int)(Math.random()*3) <- int(정수)로 형변환하면, 0,1,2 만 출력됨. 근데 우선순위 고려해서 ()괄호 잘 쳐야

		if (you == 0) {
			System.out.println("가위를 내셨군요.");
		} else if (you == 1) {
			System.out.println("바위를 내셨군요.");
		} else if (you == 2) {
			System.out.println("보를 내셨군요.");
		} else {
			System.out.println("유효하지 않은 값입니다.");
			you = 3; // 임의 지정.
		}
		scanner.close(); // 사용자가 입력해야 하는 부분 끝남. (입력값 받음)

		if (you != 3) { // you가 이상한 걸 입력하지 않았다면(3을 입력하지 않았다면) 게임을 이어간다.
			if (com == 0) {
				System.out.println("컴퓨터는 가위를 냈어요.");
			} else if (com == 1) {
				System.out.println("컴퓨터는 바위를 냈어요.");
			} else {
				System.out.println("컴퓨터는 보를 냈어요.");
			}
			// 누가 이겼는지 출력됨

			if ((you + 2) % 3 == com) {
				System.out.println("당신이 이겼어요.");
			} else if (you == com) {
				System.out.println("비겼어요.");
			} else {
				System.out.println("컴퓨터가 이겼어요.");
			} // 패턴을 발견하면, 이렇게 단순화가 가능하다. (파이썬에서 많이씀)

			// 패턴을 못 찾은 경우 아래처럼 길어짐.
			/*
			 * if (you == 0) { // 당신이 가위 if (com == 0) { System.out.println("비겼어요."); } else
			 * if (com == 1) { System.out.println("컴퓨터가 이겼어요."); } else {
			 * System.out.println("당신이 이겼어요."); } } else if (you == 1) { // 당신이 바위 if (com
			 * == 0) { System.out.println("당신이 이겼어요."); } else if (com == 1) {
			 * System.out.println("비겼어요."); } else { System.out.println("당신이 졌어요."); } }
			 * else if (you == 2) { // 당신이 보 if (com == 0) { System.out.println("당신이 졌어요.");
			 * } else if (com == 1) { System.out.println("당신이 이겼어요"); } else {
			 * System.out.println("비겼어요."); }
			 */

		} // if
	}// main
}// class

