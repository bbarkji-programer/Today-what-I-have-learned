package com.tj.q01;

public class MainClass {
	public static void main(String[] args) {
		
		Student st1 = new Student("A01", "강유미", "JAVA반");
		Student st2 = new Student("A02", "홍길동", "C++반");
		Staff sf1 = new Staff("S01", "유길동", "운영지원팀");
		Staff sf2 = new Staff("S02", "유민동", "취업지원팀");
		Gangsa ga1 = new Gangsa("G01", "이길동", "객체지향");
		
		Person[] person = {st1, st2, sf1, sf2, ga1};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		
	}
}
