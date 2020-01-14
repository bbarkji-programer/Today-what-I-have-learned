package com.tj.ex01_square;
public class Square {
	private int side;
	public Square() {   //default 생성자
		System.out.println("매개 변수 없는 생성자 함수를 호출");
	}
	public Square(int side) {
		this.side = side;
		System.out.println("매개 변수 있는 생성자 함수를 호출");
	}
	public int area() {
		return side*side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
