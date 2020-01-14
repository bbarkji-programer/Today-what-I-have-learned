package com.tj.ex04_object;

public class Ex06_RectMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle (5, 6, "#FF0000"); // 빨/그/파
		Rectangle r2 = (Rectangle)r1.clone();
		System.out.println(r1);
		System.out.println(r2);
		if(r1==r2) { // 주소가 같은가?
			System.out.println("복제한 건 아니고, 같은 객체인 것(=주소 같음)"); //true
		}else {
			System.out.println("복제를 했네. 다른 객체인 것(=주소 다름)"); // false
		}
		if(r1.equals(r2)) { // 내용이 같은가?
			System.out.println("같은 사각형"); // true
		}else {
			System.out.println("다른 사각형"); //false
		}
	}
}
