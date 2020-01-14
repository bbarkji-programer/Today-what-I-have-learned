package com.tj.ex10_customer;
// customer, staff 의 공통분모
public class Person {
	
	private String name;
	private String tel; // Person p = new Person("홍길동", "9999-9999")

	public Person(String name, String tel) {
		super(); // object의 생성자
		this.name = name;
		this.tel = tel;
	}
	public String infoString() { //sysout(p.infoString())
		return "[이름]"+name+" [전화]"+tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
