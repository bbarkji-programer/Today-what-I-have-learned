package com.tj.ex05_scanner;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름? ");
		String name = scMain.next();
		action(); // 여기서 scanner 가 닫혀벌임
		System.out.print("나이? ");
		int age = scMain.nextInt();
		System.out.println("나이는 "+age);
		
		
		
		scMain.close();
	}
	private static void action() { // 별명을 받아서 추력하는 일
		Scanner scAction = new Scanner(System.in);
		System.out.print("별명? ");
		String nickName = scAction.next();
		System.out.println("별명은 "+nickName);
//		scAction.close(); 여기서 닫아 벌이면
	}
}
