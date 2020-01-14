package com.tj.condition;

import java.util.Scanner;

// 사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 이하인지 출력해 보자!
public class If_q03 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("국어 점수를 입력해주세요.");
		int kor = scanner.nextInt();

		System.out.println("영어 점수를 입력해주세요.");
		int eng = scanner.nextInt();

		System.out.println("수학 점수를 입력해주세요.");
		int mat = scanner.nextInt();

		double avg = (double)(kor + eng + mat) / 3;

		if (kor >= avg) {
			System.out.println("국어 점수는 평균 이상입니다.");
		} else {
			System.out.println("국어 점수는 평균 미만입니다.");
			//System.out.printf("국어는 평균(%.2f)미만", avg);
		}
		if (eng >= avg) {
			System.out.println("영어 점수는 평균 이상입니다.");
		} else {
			System.out.println("영어 점수는 평균 미만입니다.");
		}
		if (mat >= avg) {
			System.out.println("수학 점수는 평균 이상입니다.");
		} else {
			System.out.println("수학 점수는 평균 미만입니다.");
		}//if
		scanner.close();
	}//main	
}//class

// 삼항 연산자 입력하면 좀 더 단순화 할 수 있음
