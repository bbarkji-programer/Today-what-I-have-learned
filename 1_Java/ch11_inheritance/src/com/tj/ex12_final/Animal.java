package com.tj.ex12_final;

public class Animal {
	protected int speed;
	
	public void running() {
		speed += 5;
		System.out.println("달리고 있어요. 현재 속도는 "+speed+"km/s");
	}
	public final void stop() { // stop() 는 override 금지!
		speed = 0;
		System.out.println("멈췄당!");
	}
}
