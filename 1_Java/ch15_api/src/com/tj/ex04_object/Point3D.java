package com.tj.ex04_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;
	
	public Point3D() {	
	}
	
	public Point3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) { // r1.equals(r2)
			boolean xChx = this.x == ((Point3D)obj).x;
			boolean yChx = this.y == ((Point3D)obj).y;
			boolean zChx = this.z == ((Point3D)obj).z;
			return xChx && yChx && zChx;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "["+x+", "+y+", "+z+"]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
