package com.tj.ex02_date;

public class MainClass {

	public static void main(String[] args) {
		
		Sawon1 s1 = new Sawon1("200121", "홍길동", Sawon1.COMPUTER);
		Sawon1 s2 = new Sawon1("200122", "김길동", Sawon1.DESIGN);
		Sawon1 s3 = new Sawon1("200123", "최길동", Sawon1.HUMANRESOURCES);
		System.out.println(s1.infoString());
		System.out.println(s2.infoString());
		System.out.println(s3.infoString());
		
		Sawon2 s4 = new Sawon2("c1234", "박길동", PartType.PLANNING);
		System.out.println(s4.infoString());
	}
}
