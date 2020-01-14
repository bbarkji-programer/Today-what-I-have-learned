package com.tj.ex05_scanner;

import java.util.Scanner;
// 넥스트 라인을 하기 전에는 버퍼를 지워야 한다.
public class Ex01_nextLine {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요~");
		int i = scanner.nextInt();
		System.out.println("입력한 정수는 "+i);
		
		System.out.println("이름을 입력하세요~");
		String name = scanner.next();
		System.out.println("입력한 이름은 "+name);
		
		System.out.println("주소를 입력하세요~");
		scanner.nextLine(); // 버퍼에 남아있는 \n 을 지우기 위해 써줘야 한다. 
		String address = scanner.nextLine();
		System.out.println("입력한 주소는 "+address);
		System.out.println("----------------끝---------------");
		scanner.close();
	}	
}
