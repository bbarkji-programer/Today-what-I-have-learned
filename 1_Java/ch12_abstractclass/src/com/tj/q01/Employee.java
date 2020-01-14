package com.tj.q01;
// Employee employee = new SalaryEmployee("ȫ�浿", 240000000)
public abstract class Employee {
	
	private String name;
	
	public Employee() {	
	}
	public Employee(String name) {
		this.name = name;
	}
	
	public abstract int computePay();
	
	public final int computeIncentive() {
		int temp;
		temp = computePay();
		if(temp>2000000) {
			return (int)(temp*0.1);
		}else {
			return 0;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
