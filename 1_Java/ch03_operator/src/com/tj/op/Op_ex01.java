package com.tj.op;

public class Op_ex01 {

	public static void main(String[] args) {
		
		System.out.println("* * * 산술연산자 * * *");
		
		int n1=33;
		int n2=10;
		int result;
		double resultDouble;
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result); // 정수 캐릭터 정수 = 실수 로 출력된다. 라고 먼저 포맷을 지정해 주는 것.즉, System.out.printf("출력 서식",출력할 내용);	
		
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.2f\n", n1, '/', n2, resultDouble);
		
		resultDouble = (double)n1 / 0.0;
		System.out.printf("result = %.2f\n", resultDouble);
		
		result = n1 % n2; // % 는 나머지 연산자. 나머지를 출력하는 연산자
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		// 나머지 연산자의 용도: 짝홀수 판별, x배수 판별
		
		if (n1%2 == 0) {
			System.out.println("n1은 짝수입니다.");
		} // if문 블럭 안의 내용이 '참' 이면, {} 안의 내용을 출력
		else {
			System.out.println("n1은 홀수입니다.");
		} // 참이 아니면, else {}를 출력
		
		if (n2%5 == 0) {
			System.out.println("n2는 5의 배수입니다.");
		}
		else {
			System.out.println("n2는 5의 배수가 아닙니다.");
		}
	}
}
