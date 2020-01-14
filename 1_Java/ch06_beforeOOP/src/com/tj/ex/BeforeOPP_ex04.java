package com.tj.ex;

import java.util.Scanner;

// 4! = 4*3!
// 3! = 3*2*1
// 2! = 2 * 1
// 1! = 1

public class BeforeOPP_ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.println("몇 !을 계산할까요? ");
			num = scanner.nextInt();
		} while (num <= 0);
		long result = factorial(num);
		System.out.println(num + "!=" + result);
	} 

	private static long factorial(int num) {
		if (num == 1) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
		
	}

	
//	private static long factorial(int num) {
//		long result = 1;
//		for (long i = num; i >= 1; i--) {
//			result *= i;
//		}
//		return result;
//	}

}
