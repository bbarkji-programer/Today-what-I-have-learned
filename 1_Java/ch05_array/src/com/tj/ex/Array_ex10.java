package com.tj.ex;

// ������ ����3) 76,45,34,89,100,50,90,92
// 8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� ����, ���, �ִ밪, �ּҰ��� ����ϼ�.
public class Array_ex10 {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int tot = 0; // ����
		double avg; // ���
		int max = -9999; // �ִ밪
		int min = 9999; // �ּҰ�
		for (int temp : arr) {
			tot += temp; // ����
			if (max < temp) {
				max = temp;
			} // �ִ밪ó��
			if (min > temp) {
				min = temp;
			} // �ּҰ�ó��
		} // for
		avg = tot / arr.length;
		System.out.println("����: " + tot + ", ���: " + avg);
		System.out.println("�ִ밪: " + max + ", �ּҰ�: " + min);// ���
	}// main
}// class
