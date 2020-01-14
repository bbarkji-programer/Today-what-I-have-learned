package com.tj.ex04_object;

public class Rectangle implements Cloneable { // 빨간색 가로 5, 세로6 네모
	private int width;
	private int height;
	private String color;
	
	public Rectangle() {
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
		public String toString() {
			return "가로: "+width+", 세로: "+height+", 컬러: "+color+"인 사각형";
	}
	
	@Override
		public boolean equals(Object obj) { // r1.equals(r2) r1:this, r2:obj
			if(obj!=null && obj instanceof Rectangle) {
				boolean widthChk = this.width == ((Rectangle)obj).width;
				boolean heightChk = this.height == ((Rectangle)obj).height;
				boolean colorChk = this.color.equals(((Rectangle)obj).color); // String 객체형 데이터니까 .equals()
				return widthChk && heightChk && colorChk;
			}else {
				return false;
			}
		}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone(); // 안고쳐두 된당~
	}
	

	
	}
	
	
