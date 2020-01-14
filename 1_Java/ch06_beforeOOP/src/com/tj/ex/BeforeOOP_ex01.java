package com.tj.ex;

public class BeforeOOP_ex01 {
	public static void main(String[] args) {
		int tot=0;
		for(int i=1 ; i<=10; i++) {
			tot += i;
		}
		System.out.println("1부터 10까지 누적합은 "+tot+"입니다.");
		System.out.println((tot%2==0)? "짝수입니다." : "홀수입니다.");
		tot = 0 ;
		for(int i=10 ; i<=100 ; i++) {
			tot  += i;
		}
		System.out.println("10부터 100까지 누적합은 "+tot+"입니다.");
		System.out.println((tot%2==0)? "짝수입니다." : "홀수입니다.");
	}//main
	
}
