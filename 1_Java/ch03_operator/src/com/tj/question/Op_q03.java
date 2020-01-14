package com.tj.question;

import java.util.Scanner;

public class Op_q03 {
// 입력한 두 수를 비교연산자를 이용하여, 비교한 결과가 true면 O, false면 X를 출력하시오.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번 째 수 : ");
		int num1 = scanner.nextInt();
		System.out.print("두 번 째 수 : ");
		int num2 = scanner.nextInt();
		
		boolean result = num1 == num2;
		System.out.println("num1 == num2 는?\t" +((result==true)? "O":"X"));
		
		result = num1 != num2;
		System.out.println("num1 != num2 는?\t" +((result==true)? "O" : "X"));
		
		result = num1 > num2;
		System.out.println("num1 > num2 는?\t" +((result==true)? "O" : "X"));
		
		result = num1 < num2;
		System.out.println("num1 < num2 는?\t" +((result==true)? "O" : "X"));
		
		
		
		scanner.close();
	}

}
