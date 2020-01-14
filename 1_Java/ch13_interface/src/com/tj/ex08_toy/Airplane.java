package com.tj.ex08_toy;

public class Airplane implements IMissile, ILight {

	public Airplane() {
		System.out.println("비행기 입니다.");
		canLight();
		canMisile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
	
	@Override
	public void canLight() {
		System.out.println("불빛을 쏠 수 있습니다.");
	}

	@Override
	public void canMisile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

}
