package com.tj.condition;

import java.util.Scanner;

// 두 수를 입력 받아 몇 번째 수가 더 큰지 그리고 그 큰 수를 출력

public class If_ex03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력하세요.");
		int num1 = scanner.nextInt();
		System.out.print("두 번째 수를 입력하세요.");
		int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("첫 번째 입력한 ("+num1+")이 더 큽니다.");
		}else if(num1<num2) {
			System.out.println("두 번째 입력한 ("+num2+")이 더 큽니다.");
		}else {
			System.out.println("같은 수를 두 번 입력하셨습니다.");
		} //if
		scanner.close();

	} //main

} //class
