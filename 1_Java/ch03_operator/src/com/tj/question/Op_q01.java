package com.tj.question;

import java.util.Scanner;

// 사용자로부터 정수를 입력 받아 3의 배수인지 아닌지 출력
public class Op_q01 {
	public static void main(String[] args) {
	//  예를 들어, String name = 잡다구리를 포함한 메모리가 잡혀있네... <- 뭔소리야...
	//  String name = "홍길동";
		
		Scanner scanner = new Scanner(System.in); // new 연산자로 메모리를 만들어서 잡다구리를 가져온 것...? 메모리에 안착시키는 역할
		System.out.print("입력하고자 하는 정수 값은 ?"); // 한글 칠 때는 유의해야함, 오라클에서 만든거라소
		int i = scanner.nextInt(); // nextInt()는 키보드로부터 정수를 입력하는 역할 <- 사용자가 정수를 입력할 때까지 기다린다.
		
		System.out.println(i%3==0 ? "3의 배수를 입력했네" : "3의 배수가 아니군");
		scanner.close();
	}
}
