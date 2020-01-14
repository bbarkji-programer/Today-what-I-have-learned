package com.tj.ex06_boxorrect;

public class Box_or_Rect_main {
	public static void main(String[] args) {
		Box_or_Rect box = new Box_or_Rect(5, 6, 10);
		Box_or_Rect rect = new Box_or_Rect(5, 6);

		box.calVolume();
		rect.calVolume();

		System.out.println("가로: " + box.getWidth() + ", 세로: " + box.getHeight() + ", 높이: " + box.getDepth()
				+ "인 박스의 부피는 " + box.getVolume() + "세제곱 센티미터 입니다.");
		System.out.println("가로: " + rect.getWidth() + ", 세로: " + rect.getHeight() 
				+ "인 직사각형의 넓이는 " + rect.getVolume() + "제곱센티미터 입니다.");
	}
}
