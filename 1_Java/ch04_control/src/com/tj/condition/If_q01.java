package com.tj.condition;

import java.util.Scanner;

// ���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
public class If_q01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���.");
		int num = scanner.nextInt();
		if (num > 0) {
			System.out.println("�Է��� ���� ���밪��\t" + num);
		} else {
			System.out.println("�Է��� ���� ���밪��\t" + (num * -1)); // +(-num)) ���� �ص� �ȴ�.
		}//if
		scanner.close();
	}//main
	}//class
