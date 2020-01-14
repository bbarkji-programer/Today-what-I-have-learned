package com.tj.condition;

import java.util.Scanner;

// 수를 입력받아 절대값을 출력하는 프로그램
public class If_q01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요.");
		int num = scanner.nextInt();
		if (num > 0) {
			System.out.println("입력한 수의 절대값은\t" + num);
		} else {
			System.out.println("입력한 수의 절대값은\t" + (num * -1)); // +(-num)) 으로 해도 된다.
		}//if
		scanner.close();
	}//main
	}//class
