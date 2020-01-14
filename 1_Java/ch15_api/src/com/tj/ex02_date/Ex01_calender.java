package com.tj.ex02_date;

import java.util.Calendar;
// 현재의 날짜 가져오기.
public class Ex01_calender {

	public static void main(String[] args) {
		
//		Calendar calendar = new Calendar(); <- Calendar()가 싱글톤 클래스라 new 안됨.
		Calendar calendar = Calendar.getInstance(); // 싱글톤이라 getInstance로 가져와야. (현재 날짜는 한가지니까 싱글톤)
		System.out.println("[그냥 출력]");
		System.out.println(calendar); // 그냥 출력하면 값이... 
		
		int year = calendar.get(Calendar.YEAR); // 2019
		int month = calendar.get(Calendar.MONTH)+1; // 컴퓨터 month가 0월~11월 이라 +1 해줘야 함. 
		int day = calendar.get(Calendar.DAY_OF_MONTH); 
		int week = calendar.get(Calendar.DAY_OF_WEEK); //일:1, 월:2, 화:3 ~ 토:7
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY); //24시간 기준
		int ampm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);//12시간 기준
		int minute = calendar.get(Calendar.MINUTE); //분
		int second = calendar.get(Calendar.SECOND); //초
		int milliSec = calendar.get(Calendar.MILLISECOND); //밀리세컨
		
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
