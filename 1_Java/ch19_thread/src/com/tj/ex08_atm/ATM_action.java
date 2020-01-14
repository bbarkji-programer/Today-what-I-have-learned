package com.tj.ex08_atm;

public class ATM_action implements Runnable {

	private boolean flag;
	private ATM obj;
	
	public ATM_action(ATM obj) { // 초기화
		flag = false;
		this.obj = obj; // 매개변수로 받기
	}
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) { // 넣고, 찾는 걸 10번 한다.
			if(flag) { // if 값이 true 이면,
				obj.deposit(1000, Thread.currentThread().getName()); // deposit 한다.
				flag = false;
			}else {
				obj.withdraw(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
	}

}
