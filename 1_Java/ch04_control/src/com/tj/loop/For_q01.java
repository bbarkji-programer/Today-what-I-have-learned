package com.tj.loop;

// 1~10������ ���� ���غ���.
public class For_q01 {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 1; i <= 10; i++) {
			num *= i;
			if (i == 10) {
				System.out.println("1~10������ ���� "+num);
			}
		}
	}
}
