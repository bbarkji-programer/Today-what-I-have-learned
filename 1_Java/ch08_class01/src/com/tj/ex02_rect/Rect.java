package com.tj.ex02_rect;

public class Rect {
	//변수 선언
	private int width;
	private int height;
	//생성자(main함수의 new변수 개수만큼 필요)
	public Rect() { //default 생성자
	}
	public Rect(int side) { //매개 변수가 하나인 경우
		width=height=side;
	}
	public Rect(int width, int height) { //매개 변수가 두개인 경우
		this.width = width;
		this.height = height;
	}
	//이거 해(실행값) 
	public int area() {
		return width*height;
	}
	//setter, getter
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}	
}
