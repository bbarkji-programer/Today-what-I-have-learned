package com.tj.loop;

import java.util.Scanner;

//��ǻ�Ϳ� ���������� ������ -1�� �Է��Ҷ����� ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
//(��, ������� 0, ������� 1, ����� 2, ���Ḧ ���ϸ� -1�� �Է��մϴ�)

public class Homework_04 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int you = 9, com;

		while (you != -1) {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ�(����)�� �Է����ּ���. �׸��ϰ� ���� ���� (-1)�� �Է����ּ���.");

			you = scanner.nextInt();
			com = (int) (Math.random() * 3);

			if (you == -1) {
				System.out.println("������ �����մϴ�.");
			} else if ((you + 2) % 3 == com) {
				System.out.println("�����" + (you == 0 ? "����" : you == 1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ�" + (com == 0 ? "����" : com == 1 ? "����" : "��"));
				System.out.println("����� �̰���.");
			} else if (you == com) {
				System.out.println("�����" + (you == 0 ? "����" : you == 1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ�" + (com == 0 ? "����" : com == 1 ? "����" : "��"));
				System.out.println("�����.");
			} else {
				System.out.println("�����" + (you == 0 ? "����" : you == 1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ�" + (com == 0 ? "����" : com == 1 ? "����" : "��"));
				System.out.println("����� �����.");
			} // if
		} // while
		scanner.close();
	}// main
}// class
