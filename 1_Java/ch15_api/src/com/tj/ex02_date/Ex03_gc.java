package com.tj.ex02_date;

import java.util.GregorianCalendar;

public class Ex03_gc {

	public static void main(String[] args) {
		
		GregorianCalendar gcThat = new GregorianCalendar(2019, 10, 25, 9, 30, 0); // 특정 시점을 가르켜라.(컴퓨터 시계인 점 고려)
		GregorianCalendar gcNow = new GregorianCalendar(); // 현재의 시점을 가르켜라.
		
		System.out.println("1970년 1월 1일 0시 0분 0초부터 지금까지의 밀리세컨은 다음과 같다.");
		System.out.println(System.currentTimeMillis());
		System.out.println(gcNow.getTimeInMillis()); // 1970.1.1 ~ gc시점까지의 밀리세컨
		System.out.println(gcThat.getTimeInMillis());
		
	}
}
