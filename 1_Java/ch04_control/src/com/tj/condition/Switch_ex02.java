package com.tj.condition;

import java.util.Scanner;

// ���� �Է� �޾Ƽ� ������ ����غ���~ (if, switch��)
// switch ���

public class Switch_ex02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է����ּ��� : ");

		int score = scanner.nextInt(); // �������� �޾ƿ´ٴ� �ǹ��̴�. nextInt()
		int temp = score == 100 ? score - 1 : score;
		// score�� 100���̸�, temp�� 99 <- 100���� A������ ���Խ�Ű�� ���� ���� 
		// (*case10 ���� �Ʒ��� �߰��� �ϴ� ��� 102, 105 ���� ������ �����.)

		switch (temp / 10) {
		case 9:
			System.out.println("A����");
			break;
		case 8:
			System.out.println("B����");
			break;
		case 7:
			System.out.println("C����");
			break;
		case 6:
			System.out.println("D����");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("F����");
			break;
		default:
			System.out.println("��ȿ���� ���� �����Դϴ�.");
		}
		scanner.close();
	}
}
