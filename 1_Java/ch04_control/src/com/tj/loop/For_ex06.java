package com.tj.loop;

// ���ѹݺ� ���� (�� ����)
public class For_ex06 {
	public static void main(String[] args) {
		for (int i = 0; true; i++) {
			System.out.println("Hello, JAVA");
			if (i == 10) {
				break;
			}
		}
		System.out.println("DONE");
	}
}
