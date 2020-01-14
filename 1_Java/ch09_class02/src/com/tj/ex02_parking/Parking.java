package com.tj.ex02_parking;

import com.tj.cons.Pi_class;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private static final int HOURLYPARKINGRATE = 2000; // final변수 = 상수, 상수는 대문자(ctrl+shift+x)로 친다.
	
	public Parking() {
		
	}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println(no+"님 어서요세요.");
		System.out.println("입차시간: "+inTime+"시");
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)*Pi_class.HOURLYPARKINGRATE;
		System.out.println(no+"님 안녕히 가세요.");
		System.out.println("입차시간: "+inTime+"시");
		System.out.println("출차시간: "+outTime+"시");
		System.out.println("주차요금: "+fee+"원");
	}
}
