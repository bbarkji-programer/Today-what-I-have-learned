package com.tj.ex03_point;

public class Point_3d extends Point {
	
	private int z;
	public void point_3dPrint() {
		System.out.println("3Â÷¿ø ÁÂÇ¥: "+getX()+", "+getY()+", "+z);
	}
	public String point_3dInfoString() {
		return "3Â÷¿ø ÁÂÇ¥: "+getX()+", "+getY()+", "+z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}
