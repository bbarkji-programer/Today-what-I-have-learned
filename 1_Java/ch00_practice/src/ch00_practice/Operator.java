package ch00_practice;

import java.util.Scanner;

public class Operator {
	public static void main(String[] args) {
		int age;

			System.out.println("���̸� �Է����ּ��� -> ");
			Scanner scanner = new Scanner(System.in);
			age = scanner.nextInt();
			if(age>=65) {
				System.out.println("��ο��");
			}else {
				System.out.println("�Ϲ�");
			}
		}
	}

