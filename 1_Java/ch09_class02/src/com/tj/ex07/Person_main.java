package com.tj.ex07;

public class Person_main {
	public static void main(String[] args) {
		System.out.println(Person.company_money); // class�� static ������ ��ü�� ����� ���� �ٷ� �� �� �ִ�.
		Person.staticTestMethod();
		Person p1 = new Person("ȫ�浿");
		Person p2 = new Person("�̱浿");
		p1.saveMoney(1000);
		p1.saveCompany_money(1000);
		p1.currentMoney();
		p2.saveMoney(1000);
		p2.saveCompany_money(1000);
		p2.currentMoney();
		
	}
}
