package com.tj.ex05_car;

public class LowGradeCar extends Car {
	//������
	private int tax = 50000;
	//������
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);	
	}
	//�޼ҵ�
	@Override
	public void getSpec() {
		if(getDisplacement()>=1500) {
			tax += 50000;
		}
		System.out.println("�÷�: "+getColor());
		System.out.println("Ÿ�̾�: "+getTire());
		System.out.println("��ⷮ: "+getDisplacement());
		System.out.println("�ڵ�: "+getHandle());
		System.out.println("����: "+tax);
		
	}

}
