package com.tj.ex08_toy;

public class Airplane implements IMissile, ILight {

	public Airplane() {
		System.out.println("����� �Դϴ�.");
		canLight();
		canMisile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
	
	@Override
	public void canLight() {
		System.out.println("�Һ��� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void canMisile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

}
