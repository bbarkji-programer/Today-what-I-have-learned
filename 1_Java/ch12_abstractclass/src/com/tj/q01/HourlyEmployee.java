package com.tj.q01;

public class HourlyEmployee extends Employee {

	private int h; // �ñ�
	private int t; // ���ѽð�
	
	public HourlyEmployee(String name, int h, int t) {
		super(name);
		this.h = h;
		this.t = t;
	}
	@Override
	public int computePay() {
		return h*t;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
}
