package com.tj.ex08_toy;

public class Mazinger implements IMoveArmLeg, IMissile {

	public Mazinger() {
		System.out.println("��¡�� �Դϴ�.");
		canMoveArmLeg();
		canMisile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMisile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ִ�.");
	}

}
