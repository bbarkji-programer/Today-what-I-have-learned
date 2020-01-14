package com.tj.ex04_man;

public class Man {

	// �ʿ��� ������
	private int age;
	private int height;
	private int weight;
	private String phoneNum; // 010-9999-9999, 01099999999 �� �� ���ڰ� �ƴϴ�.

	// �Ű� ������ ���� ��� ������ : Man man = new Man()
	public Man() {
		System.out.println("�Ű� ������ ���� �����ڰ� ȣ��ȴ�.");
	}

	// �Ű� ������ 4���� ��� ������ : Man man = new Man(28, 168, 57, 01050910108)
	public Man(int age, int height, int weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
	}

	// �Ű� ������ 2���� ��� ������ : Man man = new Man(168, 57)
	public Man(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	// �Ű� ������ 1���� ��� ������ : Man man = new Man(57.5)
	public Man(double weight) {
		this.weight = (int) weight;
	}

	// ���� �޼ҵ�
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
