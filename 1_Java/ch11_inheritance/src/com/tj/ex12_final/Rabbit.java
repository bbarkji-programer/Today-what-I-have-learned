package com.tj.ex12_final;

public final class Rabbit extends Animal{
	
	@Override
	public void running() {
		speed += 30;
		System.out.println("���� ���� �پ��. ���� �ӵ��� "+speed+"km/s");
	}
}
