package com.tj.ex01_string;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// x�� ������ ����. ������ ����� ���� �ݺ�~
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("���ϴ� ��ɹ�ȣ��? (1:����, 2:�ݳ�, x:����)");
			fn = scanner.next(); // x�� �޾ƾ� �ϴϱ� int�� �ϸ� �ȵ�.
			if(fn.equals("1")) {
				System.out.println("����~");
			}else if(fn.contentEquals("2")) {
				System.out.println("�ݳ�~");
			}
		}while(! fn.equalsIgnoreCase("x")); {// fn�� x �� X�� �ƴϸ�(!) do�� ��� �ض�~
			System.out.println("����!");
		}
		scanner.close();
	}
}
