package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	
	private String add; // 주소
	private int sum; // 누적금액
	private int point; // 포인트(구매할 때 마다 5% 적립)
	private String date; // 기념일
	private boolean vip; // true=vip고객, false=일반고객
	
	// Customer c = new Customer("홈","9999-9999","서울","0108");
	public Customer(String name, String tel, String add, String date) { 	
		// super단 생성자 호출은 반드시 첫 번째 라인!!
		super(name, tel); // 매개 변수 없는 생성자 끊고, 있는 생성자 호출
		this.add = add;
		this.date = date;
		sum = 0 ; // 새로운 고객은 누적금액 0원
		point = 1000; // 회원가입 시 1,000점 포인트 자동지급
		vip = false; // 새로운 고객은 일반고객으로 자동분류
		System.out.println(name+"님 감사합니다. 어서오셔용. 포인트 1000점이 선물로 지급되었어용.");
	}
	public void buy(int price) {
		// c.buy(10000);
		sum += price;
		int tempPoint = (int)(price*Constant.RATE);
		point += tempPoint;
		System.out.println(getName()+"님 감사합니다. 금번 포인트: "+tempPoint
				           +"점, 총 포인트: "+point+"점 입니당.");
		if(sum>1000000 && vip==false) {
			vip = true; // 누적 금액이 1백만 원 초과 시 vip 고객으로
		}//if			
	}//buy
	// [이름]홍길동 [전화]0000-0000 [주소]서울종로 [포인트] 500
	@Override
	public String infoString() {
		return super.infoString()+" [주소]"+add+" [포인트]"+point;
	}

}
