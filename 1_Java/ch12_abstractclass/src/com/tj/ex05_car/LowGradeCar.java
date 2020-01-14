package com.tj.ex05_car;

public class LowGradeCar extends Car {
	//데이터
	private int tax = 50000;
	//생성자
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);	
	}
	//메소드
	@Override
	public void getSpec() {
		if(getDisplacement()>=1500) {
			tax += 50000;
		}
		System.out.println("컬러: "+getColor());
		System.out.println("타이어: "+getTire());
		System.out.println("배기량: "+getDisplacement());
		System.out.println("핸들: "+getHandle());
		System.out.println("세금: "+tax);
		
	}

}
