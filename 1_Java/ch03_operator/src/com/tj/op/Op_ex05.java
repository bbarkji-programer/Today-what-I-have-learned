package com.tj.op;

public class Op_ex05 {
	public static void main(String[] args) {
		System.out.println("* * *삼항연산자* * *");
		// 삼항연산자 // 조건 ? 조건이 참일 때 취할 값 : 조건이 거짓일 때 취할 값
		
		int h=100;
		String result = (h%2==0) ? "짝수네" : "홀수네";
		System.out.println(result);
		
		// 간략하게 한 줄로 쓴다면,
		System.out.println((h%2==0)? "짝수네":"홀수네");
	}		
}
