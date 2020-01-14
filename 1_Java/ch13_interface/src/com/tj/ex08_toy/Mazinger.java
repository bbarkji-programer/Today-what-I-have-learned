package com.tj.ex08_toy;

public class Mazinger implements IMoveArmLeg, IMissile {

	public Mazinger() {
		System.out.println("마징가 입니다.");
		canMoveArmLeg();
		canMisile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMisile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있다.");
	}

}
