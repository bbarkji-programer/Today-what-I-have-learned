package com.tj.ex08_atm;

public class ATM_action implements Runnable {

	private boolean flag;
	private ATM obj;
	
	public ATM_action(ATM obj) { // �ʱ�ȭ
		flag = false;
		this.obj = obj; // �Ű������� �ޱ�
	}
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) { // �ְ�, ã�� �� 10�� �Ѵ�.
			if(flag) { // if ���� true �̸�,
				obj.deposit(1000, Thread.currentThread().getName()); // deposit �Ѵ�.
				flag = false;
			}else {
				obj.withdraw(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
	}

}
