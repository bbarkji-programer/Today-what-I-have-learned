package com.tj.op;

public class Op_ex07 {

	public static void main(String[] args) {
		System.out.println("* * *비트연산자* * *");
		
		int i1 = 10; 			// 0 0 0 0 1 0 1 0 (int기 때문에 앞에 000000)
		int i2 = 5;  			// 0 0 0 0 0 1 0 1 <- 비트 별로 계산하는 게 비트 연산자 
		
		int result = i1 & i2;   // 0 0 0 0 0 0 0 0 <- & 하나만 있으면 비트 연산. 0은 false, 1은 true 
		System.out.println(result);
		
		result = i1 | i2;		// 0 0 0 0 1 1 1 1 
		System.out.println(result);
		
		result = i1 << 1;       // 0 0 0 1 0 1 0 0 <- i를 한 자리 왼쪽으로 shift (/2랑 같음)
		System.out.println(result);
		
		result = i1 >> 1;       // 0 0 0 0 0 1 0 1 <- i를 한 자리 왼쪽으로 shift (*2랑 같음)
		System.out.println(result);
		
	}

}
