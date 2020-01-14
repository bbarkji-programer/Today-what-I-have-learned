package com.tj.ex04_man;

public class Man {

	// 필요한 데이터
	private int age;
	private int height;
	private int weight;
	private String phoneNum; // 010-9999-9999, 01099999999 둘 다 숫자가 아니다.

	// 매개 변수가 없는 경우 생서자 : Man man = new Man()
	public Man() {
		System.out.println("매개 변수가 없는 생성자가 호출된다.");
	}

	// 매개 변수가 4개인 경우 생성자 : Man man = new Man(28, 168, 57, 01050910108)
	public Man(int age, int height, int weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
	}

	// 매개 변수가 2개인 경우 생성자 : Man man = new Man(168, 57)
	public Man(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	// 매개 변수가 1개인 경우 생성자 : Man man = new Man(57.5)
	public Man(double weight) {
		this.weight = (int) weight;
	}

	// 실행 메소드
	public double calculateBMI() {
		double result = weight/((height * 0.01)*(height * 0.01));
		return result;
	}

	// getter, setter
	// age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// height
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// weight
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	// phoneNum
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNumber(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
