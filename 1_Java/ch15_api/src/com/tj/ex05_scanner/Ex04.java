package com.tj.ex05_scanner;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("�̸�? ");
		String name = scMain.next();
		System.out.println("�̸��� "+name);
		action(scMain); // ���⼭ scanner �� ��������
		System.out.print("����? ");
		int age = scMain.nextInt();
		System.out.println("���̴� "+age);	
		scMain.close();
	}
	private static void action(Scanner scAction) { // ������ �޾Ƽ� �߷��ϴ� ��
		System.out.print("����? ");
		String nickName = scAction.next();
		System.out.println("������ "+nickName);
//		scAction.close(); ���⼭ �ݾ� ���̸�
	}

}

