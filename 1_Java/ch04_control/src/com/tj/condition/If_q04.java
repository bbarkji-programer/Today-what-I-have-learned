package com.tj.condition;

import java.util.Scanner;

// 가위바위보 중 하나를 내고 낸 것을 출력하세요~

public class If_q04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 입력해주세요. : ");
		int you = scanner.nextInt(); // 0,1,2
		if (you == 0) {
			System.out.println("가위를 내셨군요.");
		} else if (you == 1) {
			System.out.println("바위를 내셨군요.");
		} else if (you == 2) {
			System.out.println("보를 내셨군요.");
		} else {
			System.out.println("유효하지 않은 값입니다.");
		}//if
		scanner.close();
	}//main
}//class
