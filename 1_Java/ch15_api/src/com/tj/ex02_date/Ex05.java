package com.tj.ex02_date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05 {

	public static void main(String[] args) {
		
		//현재
		Calendar calNow = Calendar.getInstance();
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dateNow = new Date();
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", calNow);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", gcNow);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateNow);
		
		//특정한 시점(1990.01.08) - *Calendar는 지금 시점밖에 못가져옴.
		GregorianCalendar gcBirth = new GregorianCalendar(1990, 0, 8);
		Date dateBirth1 = new Date(90, 0, 8); // 되긴 되는데 이 방법은 비추.
		Date dateBirth2 = new Date(gcBirth.getTimeInMillis()); // 데이트로 특정시점 -> 그레고리안 캘린더 객체 만들고, 그것의 밀리세컨... 
		Date dateBirth3 = new Date(new GregorianCalendar(1990, 0, 8).getTimeInMillis()); // 만약에 그레고리안 캘린더 객체 안만든 경우, 바로 만들어서 메소드 호출
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateBirth1);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateBirth2);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateBirth3);
	}
}
