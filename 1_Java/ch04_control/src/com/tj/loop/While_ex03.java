package com.tj.loop;
// 1���� 100���� 3�� ����� �������� ���غ���
public class While_ex03 {
	public static void main(String[] args) {
		int tot = 0;
//		for(int i=1 ; i<100 ; i++) {
//			if(i%3==0) {
//				tot += i;
//			}//if
//		}//for
		int i=1;
		while(i<=100) {
			if(i%3==0) {
				tot += i;
			}
			i++;
		}
		System.out.println(tot);
	
	}//main
}//class
