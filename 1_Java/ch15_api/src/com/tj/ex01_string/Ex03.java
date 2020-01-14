package com.tj.ex01_string;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// x를 누르면 종료. 나머지 기능은 무한 반복~
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("원하는 기능번호는? (1:대출, 2:반납, x:종료)");
			fn = scanner.next(); // x도 받아야 하니까 int로 하면 안됨.
			if(fn.equals("1")) {
				System.out.println("대출~");
			}else if(fn.contentEquals("2")) {
				System.out.println("반납~");
			}
		}while(! fn.equalsIgnoreCase("x")); {// fn이 x 나 X가 아니면(!) do를 계속 해라~
			System.out.println("종료!");
		}
		scanner.close();
	}
}
