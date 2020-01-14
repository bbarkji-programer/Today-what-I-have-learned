package com.tj.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_simpleDateFormat {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 hh시 mm분");
		String todayStr = sdf.format(date); // 데이트형 포맷이기 때문에 걍 써도 된다.
		System.out.println(todayStr);
	}
}
