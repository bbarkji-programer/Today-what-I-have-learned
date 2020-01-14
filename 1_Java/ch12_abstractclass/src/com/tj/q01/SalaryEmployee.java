package com.tj.q01;

public class SalaryEmployee extends Employee {

	private int s; // ¿¬ºÀ
	
	public SalaryEmployee(String name, int s) {
		super(name);
		this.s = s;
	}
	
	@Override
	public int computePay() {
		return s/14;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}
	
}
