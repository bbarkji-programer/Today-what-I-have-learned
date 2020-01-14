package com.tj.ex02_date;

import java.util.Date;

public class Ex04_date {

	public static void main(String[] args) {
		
		Date date = new Date(); // 현재 시점을 가져온다.
		System.out.println(date);
		
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초\n", year, month, day, hour, minute, second); // 굳이 이렇게 안하고
		
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시 %tM분 %tS초\n", 
						 date, date, date, date, date, date, date ); // %tY:년 %tm:월 %td:일 %ta:요일 %tH:24시 %tM:분 %tS:초  <- 이렇게 하면 됨!
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n", date); // 근데 또 이렇게 하면 더 간단. %뒤에 1$ 추가하면, 뒤에 date 한 번만!
		
	}
}
