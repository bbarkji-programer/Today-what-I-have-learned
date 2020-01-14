package com.tj.ex;

import java.util.Scanner;

// 사용자로부터 원하는 단수 구구단을 출력하는 프로그램을 구현
// 단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다.
// 사용자가 2~9 사이의 수가 아닌 수를 입력할 시 2~9 사이의 수를 입력할 때까지 계속 입력 받는다.
public class Today01 {
	public static void main(String[] args) {
		// 사용자로부터 2~9까지 원하는 구구단을 받는다.
		
		Scanner scanner = new Scanner(System.in);
		int num;
		
		do {
			System.out.println("구구단 몇 단을 출력할까? ");	
			num = scanner.nextInt();
			if(num<=9 && num>=2) {
				break;
			}else {
				System.out.println("제대로 다시 입력해주세요.");
			}
		}while(true);
		
		guguPrint(num);
		
	}
	
	private static void guguPrint(int num) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", num, i, num * i);
		}
	}
}
