package com.tj.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_gc {

	public static void main(String[] args) {
		
		GregorianCalendar gc = new GregorianCalendar(); // 싱글톤 아님. 빈 생성자 -> 현재 날짜 출력
		System.out.println("[그냥 출력]");
		System.out.println(gc);
		
		int year = gc.get(Calendar.YEAR); // 2019
		int month = gc.get(Calendar.MONTH)+1; // 컴퓨터 month가 0월~11월 이라 +1 해줘야 함. 
		int day = gc.get(Calendar.DAY_OF_MONTH); 
		int week = gc.get(Calendar.DAY_OF_WEEK); //일:1, 월:2, 화:3 ~ 토:7
		int hour24 = gc.get(Calendar.HOUR_OF_DAY); //24시간 기준
		int ampm = gc.get(Calendar.AM_PM);
		int hour = gc.get(Calendar.HOUR);//12시간 기준
		int minute = gc.get(Calendar.MINUTE); //분
		int second = gc.get(Calendar.SECOND); //초
		int milliSec = gc.get(Calendar.MILLISECOND); //밀리세컨
		
		System.out.println();
		System.out.println("[새롭게 출력]");
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch(week) {
		case 1: System.out.print("일요일");
		break;
		case 2: System.out.print("월요일");
		break;
		case 3: System.out.print("화요일");
		break;
		case 4: System.out.print("수요일");
		break;
		case 5: System.out.print("목요일");
		break;
		case 6: System.out.print("금요일");
		break;
		case 7: System.out.print("토요일");
		break;
		}
		System.out.print((ampm==0)? " 오전 " : " 오후 ");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minute, second, milliSec);
		System.out.printf("24시간 단위 : %d시 %d분 %d초 %d\n", hour24, minute, second, milliSec);
	}
}
