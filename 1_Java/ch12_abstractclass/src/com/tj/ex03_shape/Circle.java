package com.tj.ex03_shape;

public class Circle extends Shape{

	private int r; // 반지름
	public Circle(int r) {
		this.r = r;
	}
	@Override
	public double computerArea() {
		return r*r*3.14;
	}
	@Override
	public void draw() {
		System.out.print("원 ");
		super.draw();
	}

}
