package com.tj.ex05_scanner;

import java.util.Scanner;
// �ؽ�Ʈ ������ �ϱ� ������ ���۸� ������ �Ѵ�.
public class Ex01_nextLine {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���~");
		int i = scanner.nextInt();
		System.out.println("�Է��� ������ "+i);
		
		System.out.println("�̸��� �Է��ϼ���~");
		String name = scanner.next();
		System.out.println("�Է��� �̸��� "+name);
		
		System.out.println("�ּҸ� �Է��ϼ���~");
		scanner.nextLine(); // ���ۿ� �����ִ� \n �� ����� ���� ����� �Ѵ�. 
		String address = scanner.nextLine();
		System.out.println("�Է��� �ּҴ� "+address);
		System.out.println("----------------��---------------");
		scanner.close();
	}	
}
