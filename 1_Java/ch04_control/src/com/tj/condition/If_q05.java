package com.tj.condition;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. ��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�, ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�.

public class If_q05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ�(����)�� �Է����ּ���. : ");

		int you = scanner.nextInt(); // you�� 0,1,2 �� �ϳ� �Է���.
		int com = (int) (Math.random() * 3); // com�� 0,1,2 �� �ϳ� ��µ�. (�Ʒ� ���� ����)
		// 0.0 <= Math.random() < 1 �� ����(����)�� �Ǽ��� �߻���Ű�� API
		// 0.0 <= Math.random()*3 < 3 <- �̷��� ���� �ؼ� �������~
		// (int)(Math.random()*3) <- int(����)�� ����ȯ�ϸ�, 0,1,2 �� ��µ�. �ٵ� �켱���� ����ؼ� ()��ȣ �� �ľ�

		if (you == 0) {
			System.out.println("������ ���̱���.");
		} else if (you == 1) {
			System.out.println("������ ���̱���.");
		} else if (you == 2) {
			System.out.println("���� ���̱���.");
		} else {
			System.out.println("��ȿ���� ���� ���Դϴ�.");
			you = 3; // ���� ����.
		}
		scanner.close(); // ����ڰ� �Է��ؾ� �ϴ� �κ� ����. (�Է°� ����)

		if (you != 3) { // you�� �̻��� �� �Է����� �ʾҴٸ�(3�� �Է����� �ʾҴٸ�) ������ �̾��.
			if (com == 0) {
				System.out.println("��ǻ�ʹ� ������ �¾��.");
			} else if (com == 1) {
				System.out.println("��ǻ�ʹ� ������ �¾��.");
			} else {
				System.out.println("��ǻ�ʹ� ���� �¾��.");
			}
			// ���� �̰���� ��µ�

			if ((you + 2) % 3 == com) {
				System.out.println("����� �̰���.");
			} else if (you == com) {
				System.out.println("�����.");
			} else {
				System.out.println("��ǻ�Ͱ� �̰���.");
			} // ������ �߰��ϸ�, �̷��� �ܼ�ȭ�� �����ϴ�. (���̽㿡�� ���̾�)

			// ������ �� ã�� ��� �Ʒ�ó�� �����.
			/*
			 * if (you == 0) { // ����� ���� if (com == 0) { System.out.println("�����."); } else
			 * if (com == 1) { System.out.println("��ǻ�Ͱ� �̰���."); } else {
			 * System.out.println("����� �̰���."); } } else if (you == 1) { // ����� ���� if (com
			 * == 0) { System.out.println("����� �̰���."); } else if (com == 1) {
			 * System.out.println("�����."); } else { System.out.println("����� �����."); } }
			 * else if (you == 2) { // ����� �� if (com == 0) { System.out.println("����� �����.");
			 * } else if (com == 1) { System.out.println("����� �̰���"); } else {
			 * System.out.println("�����."); }
			 */

		} // if
	}// main
}// class

