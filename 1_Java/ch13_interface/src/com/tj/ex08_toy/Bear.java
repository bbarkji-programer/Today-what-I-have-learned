package com.tj.ex08_toy;

public class Bear implements IMoveArmLeg {

	public Bear() {
		System.out.println("������ �Դϴ�.");
		canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");
	}

}
