package com.tj.condition;

import java.util.Scanner;

// ����ڷκ��� ����, ����, ���� ������ �Է¹޾� �� ���� ������ ��� �̻����� �������� ����� ����!
public class If_q03 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("���� ������ �Է����ּ���.");
		int kor = scanner.nextInt();

		System.out.println("���� ������ �Է����ּ���.");
		int eng = scanner.nextInt();

		System.out.println("���� ������ �Է����ּ���.");
		int mat = scanner.nextInt();

		double avg = (double)(kor + eng + mat) / 3;

		if (kor >= avg) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ��� �̸��Դϴ�.");
			//System.out.printf("����� ���(%.2f)�̸�", avg);
		}
		if (eng >= avg) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ��� �̸��Դϴ�.");
		}
		if (mat >= avg) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ��� �̸��Դϴ�.");
		}//if
		scanner.close();
	}//main	
}//class

// ���� ������ �Է��ϸ� �� �� �ܼ�ȭ �� �� ����
