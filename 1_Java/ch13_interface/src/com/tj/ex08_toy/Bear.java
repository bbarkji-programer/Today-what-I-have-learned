package com.tj.ex08_toy;

public class Bear implements IMoveArmLeg {

	public Bear() {
		System.out.println("곰돌이 입니다.");
		canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있습니다.");
	}

}
