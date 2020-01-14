package com.tj.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// 간단하게 포맷을 만들어주는  api
public class Ex07_simpleDateFormat {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("(w주차) yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		String todayStr = sdf.format(cal.getTime());
		// cal.getTime()은 cal을 date 형으로 바꾼 것.
		System.out.println(todayStr);
		// yyyy 2019 yy 19
		// M 9 MM 09
		// d 9 dd 09 이번달의 몇 번째 날인지(1~31)
		// D 올해의 몇 번째 날인지(1~365)
		// E 요일
		// a 오전/오후
		// H 24시간 단위 HH
		// h 12시간 단위 hh
		// m 9 mm 09 분
		// s 9 ss 09 초
		// S 밀리세컨
		// W 이번 월의 몇 번째 주인지
		// w 이번 년도의 몇 번째 주인지
		
	}
}
