package com.tj.ex;

// ������ ����1) �迭�� ��� ���� ���ϴ� ���α׷��� �ۼ�(�迭�� ������ ���)
// int[] arr = {10,20,30,40,50} 
public class Array_ex07 {
	public static void main(String[] args) {

//		int a = 10;
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110 }; // arr �̶� �ּ��� ���� �Ҵ�ǰ�, �� �ּҿ� ���ڰ� �ִ� ��
		int tot = 0; // ��������

		for (int idx = 0; idx < arr.length; idx++) {
			tot += arr[idx];
		}
		System.out.println(tot);

	}
}
