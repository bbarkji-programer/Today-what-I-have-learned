package com.tj.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζǹ�ȣ(1~45) �� ���� ���ߴ� ���α׷��� �����Ͻÿ�. 
// �� ��ȣ�� ���� ������ do~while ���� �̿��ؼ� �����Ѵ�.
public class Do_While_ex02 {
	public static void main(String[] args) {
		int lotto; // ��ǻ�Ͱ� �߻��� ������ ��(�ζǹ�ȣ)
		int su; // ����ڿ��� �Է¹��� ��
		Scanner scanner = new Scanner(System.in);

		lotto = (int) (Math.random() * 45) + 1; // ��ǻ�Ͱ� ������ ���� �߻�
		System.out.println("(�ӼӸ�): " + lotto);

		do {
			System.out.print("�ζǹ�ȣ(1~45)�� ���纸����: ");
			su = scanner.nextInt();
			if (su > lotto) {
				System.out.println(su + "���� �۾ƿ�.");				
			} else if (su < lotto) {
				System.out.println(su + "���� Ŀ��.");
			}
		} while (su != lotto);
		System.out.println("�����Դϴ�. bye");
		
		scanner.close();
	}
}
