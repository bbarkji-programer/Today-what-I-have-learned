package com.tj.ex;

// �Ϲ�for vs. Ȯ��for
// �迭 ��� ���� ���� 10% �λ�
public class Array_ex08 {
	public static void main(String[] args) {

		int[] arr = { 10, 20, 30 };

		// �Ϲ���
		for (int idx = 0; idx < arr.length; idx++) {
			arr[idx] = (int) (arr[idx] * 1.1); // �迭 ��� ���� 10% �λ�
		}
		arrayPrint(arr); // arr �迭 �����~

		// Ȯ���� -> �迭 ���� ���� �����ؾ� �Ҷ��� ������ �ȵȴ�. (�ܼ� ��¸� ����)
		for (int temp : arr) {
			temp = temp * 2; // �ӽ� ������ ������ ���� arr�� ������ ���� �ƴϴϱ�.
		}
		arrayPrint(arr);

	}// main
	private static void arrayPrint(int[] array) { // �迭�� �޾Ƽ� ����ϰڴٴ� �޼ҵ�
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println(array[idx]);
		}
	}// array
}// class