package com.tj.ex03_point;

public class Point_main {

	public static void main(String[] args) {
		Point point = new Point();
		point.setX(10);
		point.setY(5);
		Point_3d point3d = new Point_3d();
		point3d.setX(10);
		point3d.setY(5);
		point3d.setZ(2);
		point.pointPrint();
		System.out.println(point.pointInfoString());
		point3d.point_3dPrint();
		System.out.println(point3d.point_3dInfoString());

	}

}
