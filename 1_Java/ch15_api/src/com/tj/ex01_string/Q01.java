package com.tj.ex01_string;

import java.util.Scanner;

public class Q01 {
	
	public static void main(String[] args) {
	
		System.out.println("전화번호(031-234-5678)를 입력해주세요.");
		String tel; // 입력받을 전화번호 변수 선언(초기화X)


		while(true) {		// while(true)니까 중간에 break; 로 빠져나가지 않는 이상 계속 반복한다.
			Scanner scanner = new Scanner(System.in); // 전화번호를 입력받음.
			tel = scanner.next(); // 그럼 그 입력받은 값으로 변수 초기화
			
			if(tel.equalsIgnoreCase("x")) { // 만약에 입력받은 값이 x 또는 X이면,
				System.out.println("종료합니다."); // 프로그램 종료 알려주고
			break; // 반복문 빠져나가기
			}
			else if(tel.length()>10 && tel.length()<14 && tel.indexOf('-')!=tel.lastIndexOf('-')) {		// X가 아닌 무언가를 입력했는데, 그게 10글자 넘고, 14글자보다 짧고, '-'가 2개가 제대로 있으면(=제대로 입력했으면)
				System.out.println("입력한 전화번호 : "+tel); // 그 전화번호 출력
				System.out.print("짝수 번 째 문자열 : "); // 짝수번째 문자열 출력,
					for(int i=1 ; i<tel.length() ; i++ ) {
						if(i%2 != 0) {
							System.out.print(tel.charAt(i));
						}
					}
					System.out.println();
					System.out.print("전화번호를 거꾸로 : ");
					for(int i=tel.length()-1 ; i>=0 ; i--) {
						System.out.print(tel.charAt(i));
					}
					System.out.println();
					System.out.println("전화번호 앞자리는 : "+tel.substring(0,tel.indexOf('-')));
					System.out.println("전화번호 뒷자리는 : "+tel.substring(tel.lastIndexOf('-')+1));	
			}
			else {
				System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.");
			}
		}
		
	}
}
