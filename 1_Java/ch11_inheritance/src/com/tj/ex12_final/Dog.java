package com.tj.ex12_final;

public class Dog extends Animal {
	
	@Override
	public void running() {
		speed += 10; // speed가 private 라면, setSpeed(getSpeed()+10)
		System.out.println("달리면서 꼬리를 흔들어요. 현재 속도는 "+speed+"km/s");
	}
}
