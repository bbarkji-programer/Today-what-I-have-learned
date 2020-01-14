package com.tj.loop;

import java.util.Scanner;

//컴퓨터와 가위바위보 게임을 -1을 입력할때까지 무한반복하는 게임을 작성하시오.
//(단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다)

public class Homework_04 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int you = 9, com;

		while (you != -1) {
			System.out.println("가위(0), 바위(1), 보(2) 중 하나(숫자)를 입력해주세요. 그만하고 싶을 때는 (-1)을 입력해주세요.");

			you = scanner.nextInt();
			com = (int) (Math.random() * 3);

			if (you == -1) {
				System.out.println("게임을 종료합니다.");
			} else if ((you + 2) % 3 == com) {
				System.out.println("당신은" + (you == 0 ? "가위" : you == 1 ? "바위" : "보"));
				System.out.println("컴퓨터는" + (com == 0 ? "가위" : com == 1 ? "바위" : "보"));
				System.out.println("당신이 이겼어요.");
			} else if (you == com) {
				System.out.println("당신은" + (you == 0 ? "가위" : you == 1 ? "바위" : "보"));
				System.out.println("컴퓨터는" + (com == 0 ? "가위" : com == 1 ? "바위" : "보"));
				System.out.println("비겼어요.");
			} else {
				System.out.println("당신은" + (you == 0 ? "가위" : you == 1 ? "바위" : "보"));
				System.out.println("컴퓨터는" + (com == 0 ? "가위" : com == 1 ? "바위" : "보"));
				System.out.println("당신이 졌어요.");
			} // if
		} // while
		scanner.close();
	}// main
}// class
