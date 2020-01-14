package com.tj.ex04_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {
	}
	public Account(String accountNo, String ownerName) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}
	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposit(int amount) { // 예금 전 계좌정보 출력 -> 예금 -> 예금 후 계좌정보 출력
		System.out.println("예금 전 : "+this); // 현재 계좌정보 출력 (this 는 나 자신을 나타내는 예약어)
		balance += amount;
		System.out.println("예금 후 : "+this);
	}
	public void withdraw(int amount) throws Exception { // 잔액과 출금금액 비교 -> 출금 전 계좌정보 출력 -> 출금 -> 출금 후 계좌정보 출력
		if(balance<amount) {
			throw new Exception(amount+"원을 출금하기에는 잔액("+balance+"원)이 부족합니다.");
		}
		System.out.println("출금 전 : "+this);
		balance -= amount;
		System.out.println("출금 후 : "+this);
	}	
	@Override
	public String toString() {
		String temp = "계좌번호 : "+accountNo;
		temp += "\t예금주 : "+ownerName;
		temp += "\t잔액 : "+balance;
		return temp;
	}
	
}
