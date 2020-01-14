package com.tj.ex03_shape;

public class Triangle extends Shape {

	private int w;
	private int h;
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double computerArea() {
		return w*h*0.5;
	}
	@Override
	public void draw() {
		System.out.print("»ï°¢Çü ");
		super.draw();
	}

}
