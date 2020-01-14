package com.tj.op;

public class Op_ex02 {
	public static void main(String[] args) {
		
		System.out.println("* * *단항(증감) 연산자* * *");
		
		int n1 = 10;
		
		int n2 = n1++; // 이 시점에서 n1 은 10 --> n1 문자 지나서 (다음 명령 시작 전에) ++ 이 적용된다. 
		System.out.printf("n1 = %d\t n2 = %d\n",n1,n2);
		
		int n3 = ++n1;
		System.out.printf("n1 = %d\t n3 = %d\n",n1,n3);
		System.out.printf("n3 = %d, %d, %d\n", n3++, ++n3, n3);
		System.out.printf("n3 = %d\n", n3--); // 다음 연산이 있어야 그 연산 시작 전에 -- 이 적용된다.
	}
}
