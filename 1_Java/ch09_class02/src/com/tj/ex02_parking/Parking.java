package com.tj.ex02_parking;

import com.tj.cons.Pi_class;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private static final int HOURLYPARKINGRATE = 2000; // final���� = ���, ����� �빮��(ctrl+shift+x)�� ģ��.
	
	public Parking() {
		
	}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println(no+"�� ��似��.");
		System.out.println("�����ð�: "+inTime+"��");
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)*Pi_class.HOURLYPARKINGRATE;
		System.out.println(no+"�� �ȳ��� ������.");
		System.out.println("�����ð�: "+inTime+"��");
		System.out.println("�����ð�: "+outTime+"��");
		System.out.println("�������: "+fee+"��");
	}
}
