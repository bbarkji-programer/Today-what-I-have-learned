package com.tj.ex10_customer;
// customer, staff �� ����и�
public class Person {
	
	private String name;
	private String tel; // Person p = new Person("ȫ�浿", "9999-9999")

	public Person(String name, String tel) {
		super(); // object�� ������
		this.name = name;
		this.tel = tel;
	}
	public String infoString() { //sysout(p.infoString())
		return "[�̸�]"+name+" [��ȭ]"+tel;
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
