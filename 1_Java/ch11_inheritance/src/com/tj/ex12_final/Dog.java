package com.tj.ex12_final;

public class Dog extends Animal {
	
	@Override
	public void running() {
		speed += 10; // speed�� private ���, setSpeed(getSpeed()+10)
		System.out.println("�޸��鼭 ������ �����. ���� �ӵ��� "+speed+"km/s");
	}
}
