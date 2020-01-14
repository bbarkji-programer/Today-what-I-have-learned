package com.tj.ex03_shape;

public abstract class Shape {

	// default 생성자가 있는 셈
	
	public abstract double computerArea();
	public void draw() {
		System.out.println("도형을 그려용");
	}
}
