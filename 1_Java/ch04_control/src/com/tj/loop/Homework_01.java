package com.tj.loop;
// 1���� 20���� ���� �߿��� 2�� 3�� ����� �ƴ� ���� ��
public class Homework_01 {
	public static void main(String[] args) {
		int tot = 0; // ���� ���� ����
		for (int i=1 ; i<=20 ; i++) {
			if(i%2!=0 && i%3!=0) {
				tot += i;
			}//if
		}//for
		System.out.println(tot);
	}
}
