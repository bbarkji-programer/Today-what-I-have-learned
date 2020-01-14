package com.tj.loop;

import java.util.Scanner;

// 컴퓨터가 발생한 로또번호(1~45) 한 개를 맞추는 프로그램을 구현하시오. 
// 그 번호를 맞출 때까지 do~while 문을 이용해서 도전한다.
public class Do_While_ex02 {
	public static void main(String[] args) {
		int lotto; // 컴퓨터가 발생한 임의의 수(로또번호)
		int su; // 사용자에게 입력받은 수
		Scanner scanner = new Scanner(System.in);

		lotto = (int) (Math.random() * 45) + 1; // 컴퓨터가 임의의 수를 발생
		System.out.println("(귓속말): " + lotto);

		do {
			System.out.print("로또번호(1~45)를 맞춰보세요: ");
			su = scanner.nextInt();
			if (su > lotto) {
				System.out.println(su + "보다 작아요.");				
			} else if (su < lotto) {
				System.out.println(su + "보다 커요.");
			}
		} while (su != lotto);
		System.out.println("정답입니다. bye");
		
		scanner.close();
	}
}
