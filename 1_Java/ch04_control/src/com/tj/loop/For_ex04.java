package com.tj.loop;
/* 출력결과 : 15 16 17 18 19
 * 			20 21 22 23 24
 * 			...........49
 *          50  
 */			
public class For_ex04 {

	public static void main(String[] args) {
		
		for(int i=15 ; i<=50 ; i++) {
			System.out.print(i+"\t");
			if(i%5==4) {              // 패턴 발견 -> 5로 나누었을 때 나머지가 4인 경우 개행(줄바꿈) 한다.
				System.out.println(); // 개행 추가
			}
		}
		
	}
}
