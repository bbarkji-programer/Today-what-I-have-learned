package com.tj.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζǹ�ȣ(1~45) �� ���� ���ߴ� ���α׷��� �����Ͻÿ�. 
// �� ��ȣ�� ���� ������ do~while ���� �̿��ؼ� �����Ѵ�.
public class Do_While_ex03 {
	public static void main(String[] args) {
		int lotto; // ��ǻ�Ͱ� �߻��� ������ ��(�ζǹ�ȣ)
		int su; // ����ڿ��� �Է¹��� ��
		int min = 1, max = 45;

		Scanner scanner = new Scanner(System.in);

		lotto = (int) (Math.random() * 45) + 1; // ��ǻ�Ͱ� ������ ���� �߻�
		System.out.println("(�ӼӸ�): " + lotto);

		do {
			System.out.printf("�ζǹ�ȣ(%d~%d)�� ���纸����: ", min, max);
			su = scanner.nextInt();
			if (su < min || su > max) {
				System.out.println("��ȿ���� ���� ���Դϴ�.");
			} else if (su == lotto) {
				break; // �ݺ����� �������´�.
			} else if (su > lotto) {
				max = su - 1;
			} else if (su < lotto) {
				min = su + 1;
				}
		}while(true); // break�� ���� ������ �׻� ���ٴ� �ǹ�
		System.out.println("���߼̽��ϴ�.bye");
		
		scanner.close();
		
	}//main
}//class


