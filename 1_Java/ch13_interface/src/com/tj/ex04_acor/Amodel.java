package com.tj.ex04_acor;
// DMB송수신 불가, 3G, TV리모콘 탑재
public class Amodel implements IAcor {

	private String model = "A모델";
			
	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB송수신 불가");
	}

	@Override
	public void lte() {
		System.out.println(model+"은 3G 모델");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"은 TV리모콘 미탑재");
	}

}
