package com.tj.ex05_scanner;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("�̸�? ");
		String name = scMain.next();
		action(); // ���⼭ scanner �� ��������
		System.out.print("����? ");
		int age = scMain.nextInt();
		System.out.println("���̴� "+age);
		
		
		
		scMain.close();
	}
	private static void action() { // ������ �޾Ƽ� �߷��ϴ� ��
		Scanner scAction = new Scanner(System.in);
		System.out.print("����? ");
		String nickName = scAction.next();
		System.out.println("������ "+nickName);
//		scAction.close(); ���⼭ �ݾ� ���̸�
	}
}
