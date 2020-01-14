package com.tj.ex08_atm;

public class ATM {
	private int balance;
	
	public ATM(int balance) {
		this.balance = balance;
	}
	public synchronized void deposit(int amount, String who) {
		System.out.println(who+"�� �Ա� ���� �ڡڡ�");
		balance += amount;
		System.out.println(who+"�� "+amount+"�� �Ա��Ͽ� �ܾ� "+balance+"��");
		System.out.println(who+"�� �Ա� �� �ڡڡ�");
	}
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who+"�� ��� ���� �١١�");
		balance -= amount;
		System.out.println(who+"�� "+amount+"�� ����Ͽ� �ܾ� "+balance+"��");
		System.out.println(who+"�� �Ա� �� �١١�");
		
	}
	public int getBalance() {
		return balance;
	}
}
