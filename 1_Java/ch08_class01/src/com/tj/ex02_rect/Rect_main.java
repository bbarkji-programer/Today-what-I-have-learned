package com.tj.ex02_rect;

public class Rect_main {
public static void main(String[] args) {
	Rect r1 = new Rect();
	Rect r2 = new Rect(8,7);
	Rect r3 = new Rect(7);
	r1.setWidth(10);
	r1.setHeight(5);
	System.out.println(r1.area());
	System.out.println(r2.area());
	System.out.println(r3.area());
}
}
