package com.tj.loop;
// i�� 1~9 ������ ��� ������ ����ϱ�~
public class While_ex02 {
	public static void main(String[] args) {
		int tot = 0;
//		for(int i=1 ; i<10 ; i++) {
//			tot += i;
//			System.out.printf("i�� %d���� �������� %d �̴�.\n", i, tot);
//		}
		int i=1;
		while(i<10) {
			tot += i;
			System.out.printf("i�� %d���� �������� %d �̴�.\n", i, tot);
			i++;
		
		
		}
	}
}
