package com.tj.loop;

// 1~10���� ���� �� ¦��(�Ǵ� Ȧ��)�� ���� ���غ���.
public class For_q02 {
	public static void main(String[] args) {
		int tot = 0; // ���� ���� ���� ����
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				tot = tot + i;
			}
		}
		System.out.println("1~10������ ¦���� ���� " + tot);
	}
}
