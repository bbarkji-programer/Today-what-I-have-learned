package com.tj.ex;

public class Array_ex01 {
	public static void main(String[] args) {
		
//		int i = 1; // ���� ����� �ʱ�ȭ
		int[] iArr = { 10, 20, 30, 40, 50, 60, 70 }; // �� �迭 ����� ���ÿ� �ʱ�ȭ
		for (int idx = 0; idx < iArr.length; idx++) { // .length �� �迭�� ����
			System.out.println(iArr[idx]);
		}//for

		int[] iArr2 = new int[5]; // �� �迭 ����� �迭 �޸� �Ҵ� (���� ���� �� �ƴ�. �׷��� 0�� �ڵ����� ���ִ�.)
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.println(iArr2[idx]);
		}//for
		
		int[] iArr3; // �� �迭 ����. (������ Ȯ�� ��)
		iArr3 = new int[3]; // �̷��� �ؾ� �޸𸮰� �Ҵ��
		iArr3[0] = 100; // �޸� �Ҵ��� �ؾ�, ����(�ʱ�ȭ) ����
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.println(iArr3[idx]);
		}//for
		
	}//main
}//class