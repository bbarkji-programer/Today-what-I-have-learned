package com.tj.loop;

import java.util.Scanner;

// 컴퓨터가 발생한 로또번호(1~45) 한 개를 맞추는 프로그램을 구현하시오. 
// 그 번호를 맞출 때까지 do~while 문을 이용해서 도전한다.
public class Do_While_ex03 {
	public static void main(String[] args) {
		int lotto; // 컴퓨터가 발생한 임의의 수(로또번호)
		int su; // 사용자에게 입력받은 수
		int min = 1, max = 45;

		Scanner scanner = new Scanner(System.in);

		lotto = (int) (Math.random() * 45) + 1; // 컴퓨터가 임의의 수를 발생
		System.out.println("(귓속말): " + lotto);

		do {
			System.out.printf("로또번호(%d~%d)를 맞춰보세요: ", min, max);
			su = scanner.nextInt();
			if (su < min || su > max) {
				System.out.println("유효하지 않은 값입니다.");
			} else if (su == lotto) {
				break; // 반복문을 빠져나온다.
			} else if (su > lotto) {
				max = su - 1;
			} else if (su < lotto) {
				min = su + 1;
				}
		}while(true); // break가 있지 않으면 항상 돈다는 의미
		System.out.println("맞추셨습니다.bye");
		
		scanner.close();
		
	}//main
}//class


