package com.tj.ex07;

public class Person_main {
	public static void main(String[] args) {
		System.out.println(Person.company_money); // class의 static 변수는 객체를 만들기 전에 바로 쓸 수 있다.
		Person.staticTestMethod();
		Person p1 = new Person("홍길동");
		Person p2 = new Person("이길동");
		p1.saveMoney(1000);
		p1.saveCompany_money(1000);
		p1.currentMoney();
		p2.saveMoney(1000);
		p2.saveCompany_money(1000);
		p2.currentMoney();
		
	}
}
