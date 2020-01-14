package com.tj.loop;
// 구구단을 2단부터 9단까지 출력해봐여~
public class For_q04 {
	public static void main(String[] args) {
		
//		for(int i=1 ; i<10 ; i++) {
//			for(int j=2 ; j<10 ; j++) {
//				System.out.printf("%d * %d = %d\t", j, i, j*i);
//			}
//			System.out.println(); // 개행(줄바꿈)
//	}
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 9; j++) {
				System.out.printf("%d * %d = %d\t", j, i, j * i);
			}
			System.out.println();
		}
	}
}