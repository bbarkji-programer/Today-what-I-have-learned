package ch00_practice;

import java.util.Scanner;

public class Operator {
	public static void main(String[] args) {
		int age;

			System.out.println("나이를 입력해주세요 -> ");
			Scanner scanner = new Scanner(System.in);
			age = scanner.nextInt();
			if(age>=65) {
				System.out.println("경로우대");
			}else {
				System.out.println("일반");
			}
		}
	}

