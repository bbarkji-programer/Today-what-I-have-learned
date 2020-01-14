package com.tj.ex04_acor;
//DMB송수신 불가, LTE, TV리모콘 탑재
public class Bmodel implements IAcor {

	private String model = "B모델";
	
	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB송수신 가능");
	}

	@Override
	public void lte() {
		System.out.println(model+"은 LTE모델");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"은 TV리모콘 탑재");
	}

}
