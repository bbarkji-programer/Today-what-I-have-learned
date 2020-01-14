package com.tj.ex08_atm;

public class ATM_testMain {
	public static void main(String[] args) {
		ATM obj = new ATM(20000);
		Runnable card = new ATM_action(obj);
		Thread th1 = new Thread(card,"MOM");
		Thread th2 = new Thread(card,"DAD");
		th1.start();
		th2.start();
	}
}
