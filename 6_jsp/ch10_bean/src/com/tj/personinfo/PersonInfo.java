package com.tj.personinfo;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	private String address;
	
	public PersonInfo() {		
	} /* 매개변수 없는 생성자 꼭 필요*/
	public PersonInfo(String name, int age, char gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	/* getters & seters */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
