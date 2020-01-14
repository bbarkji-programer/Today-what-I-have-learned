package com.tj.ex05_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ExDayCount {
	public static void main(String[] args) {
//		Date checkOutDate = new Date(119, 10, 13); // 2019.11.13
		Date checkOutDate = new Date(new GregorianCalendar(2019,10,13).getTimeInMillis()); // 2019.11.13
		Date today = new Date();
		long checkOutMillis = checkOutDate.getTime(); // 1970.1.1~2019.11.13까지 밀리세컨
		long todayMillis = today.getTime(); // 1970.1.1~2019.12.13까지 밀리세컨
		long borrowMillis = todayMillis - checkOutMillis; // 빌린 기간 밀리세컨
		long borrowDays = borrowMillis/(24*60*60*1000); // 빌린 기간 일 수
		if(borrowDays>14) {
			System.out.println((borrowDays-14)*100+"원 연체료를 내셔야 반납처리 가능합니다.");
			Scanner sc = new Scanner(System.in);
			System.out.println("연체료를 받으셨나요? (N:반납중단, Y:반납진행)");
			String answer = sc.nextLine();
			if(answer.equalsIgnoreCase("n")) {
				System.exit(0); // System.exit(0) <- 0 이면 정상종료를 뜻함.  checkIn method에서는 return으로 대체. 
			}//if
		}//if
		System.out.println("반납처리 계속 진행");
		
	}
}
