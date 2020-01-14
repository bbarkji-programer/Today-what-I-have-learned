package com.tj.ex10_customer;

public class Staff extends Person {
	
	private String hiredate; // 2020-05-01 <- 담주부터는 date 형으로 
	private String department; // 부서
	
	// Staff s = new Staff("홍길동", "9999-9999", "2020-05-01", "전산실");
	public Staff(String name, String tel, String hiredate, String department) {
		// super는 반드시 첫 번째 라인!!!
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println(name+"님 입사를 축하합니당:D");
	}
	//sysout(s.infoString()) -> [이름]홍길동 [전화]9999-9999 [부서]전산실
	@Override
	public String infoString() { 
		return super.infoString()+" [부서]"+department;
	}
	
}


