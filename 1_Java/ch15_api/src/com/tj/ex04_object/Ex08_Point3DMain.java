package com.tj.ex04_object;

public class Ex08_Point3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p0 = new Point3D();
		Point3D p1 = new Point3D(1.1, 2.4, 3.0);
		Point3D p2 = (Point3D)p1.clone();
		System.out.println("p0 좌표값은?"+p0);
		System.out.println("p1 좌표값은?"+p1);
		System.out.println("p2 좌표값은?"+p2);
		System.out.println("p1과 p2는 복제가 제대로 됐나?");
		if(p1==p2) {
			System.out.println("아니, 복제가 아니라 같은 객체네.");
		}else {
			System.out.println("응, 복제가 제대로 됐네~");
		}
		System.out.println("p1과 p2는 같은 좌표인가?");
		if(p1.equals(p2)) {
			System.out.println("응, 같은 좌표야.");
		}else {
			System.out.println("아니, 다른 좌표야.");
		}
	}
}
