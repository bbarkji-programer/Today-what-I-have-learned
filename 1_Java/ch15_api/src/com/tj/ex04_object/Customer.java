package com.tj.ex04_object;

public class Customer {

	private String phone; // 전화번호
	private String name; // 고객명
	private int point; // 포인트
	private int sum; // 누적 구매금액
	private String birth; // 생일 01-08
	private boolean vip; // false:일반고객, true:vip고객
	
	// 메인함수에서 Customer c = new Customer("010-0000-0000","홍길동","01-08") 이렇게
	public Customer(String phone, String name, String birth) {
		super();
		this.phone = phone;
		this.name = name;
		this.birth = birth;
		point = 1000;
		sum=0;
		vip=false;
		System.out.println(name+"회원님 가입 감사합니다. 축하 포인트 1000점 드립니다.");
	}
	//sysout(c) -> 홍길동(010-0000-0000) 현재 포인트: 000점 누적금액: 0원
	@Override
	public String toString() {
		return name+"("+phone+") 현재 포인트: "+point+"점 누적금액: "+sum+"원";
	}
	
}
