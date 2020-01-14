package com.tj.op;

public class Op_ex03 {
	public static void main(String[] args) {
		System.out.println("* * *비교 연산자(관계연산자)* * *"); // 같냐, 크냐, 크거나 같냐 등
	
	int n1=33, n2=10;
	boolean result; 
	
	result = (n1 == n2); // 같냐 == 비교 연산자가 우선순위가 높음. 먼저 수행한다. (그냥 괄호 치면 편함)
	System.out.printf("%d %s %d = %b\n", n1, "==", n2, result); // 문자를 여러개 쓸 때는 %c 대신 %s, " "
	
	result = (n1 != n2); //다르냐
	System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
	
	result = (n1 > n2); //크냐
	System.out.printf("%d %s %d = %b\n", n1, ">", n2, result);
	
	result = (n1 >= n2); //크거나 같냐
	System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
	
	result = (n1 < n2); //작냐
	System.out.printf("%d %s %d = %b\n", n1, "<", n2, result);
	
	result = (n1 <= n2); //작거나 같냐
	System.out.printf("%d %s %d = %b\n", n1, "<=", n2, result);
}

	}

