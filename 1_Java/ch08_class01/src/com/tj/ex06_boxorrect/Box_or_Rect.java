package com.tj.ex06_boxorrect;

//박스 : 가로, 세로, 깊이
//직사각형 : 가로, 세로, 0
public class Box_or_Rect {
	// 필요데이터
	private int width;
	private int height;
	private int depth;
	private int volume;

	// default 생성자
	public Box_or_Rect() {
	}

	// Box 생성자
	public Box_or_Rect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	// 직사각형 생성자
	public Box_or_Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void calVolume() {
		if (depth == 0) {
			volume = width * height;
		} else {
			volume = width * height * depth;
		} // if
	}// calVolume
	// getter, setter (자동완성 : alt+shift+s)

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}// class

