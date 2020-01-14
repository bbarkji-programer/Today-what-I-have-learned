package com.tj.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon1 {

	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNUNG= "ACCOUNING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";	
	private String no; // 사번
	private String name; // 이름
	private String part; // 부서 COMPUTER, PLANNING, DESIGN, ACCOUNINT, HUMANRESOURCES
	private Date enterDate; // 입사일은 데이트형
	
	// 메인함수에서 Sawon1 kim = new Sawon1("d102-01","홍길동","PLANNING"); <- 생성한 날짜가 입사일
	
	//메소드..........
	public Sawon1(String no, String name, String part) {
		this.no = no;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}
	
	// Sawon1 y1 = new Sawon1("d102-02", "홍길동", "DESIGN", 1990,12,11); <- 특정한 날 입사일
	public Sawon1(String no, String name, String part, int year, int month, int day) {
		this.no = no;
		this.name = name;
		this.part = part;
//		enterDate = new Date(year-1900, month-1, day);
		enterDate = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	public String infoString() {
		// [사번] d102-02 [이름] 홍 [부서] DESIGN [입사일} 1990년 12월 11일 <- simpleDateFormat 사용
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return "[사번]"+no+" [이름]"+name+" [부서]"+part+" [입사일]"+sdf.format(enterDate);
	}
}
