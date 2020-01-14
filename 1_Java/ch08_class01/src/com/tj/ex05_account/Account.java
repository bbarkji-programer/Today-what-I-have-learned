package com.tj.ex05_account;

public class Account {

	// 필요한 데이터
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private int balance; // 잔액

	// Account park = new Account() 생성자 -> setter 필요
	public Account() {
		System.out.println("매개변수가 없는 생성자");
	}

	// Account park = new Account("111-111","박지영") 생성자
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	// Account park = new Account("111-111","박지영",1000) 생성자
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 기능(메소드)
	public void deposit(int money) {
		balance += money;
		System.out.println("감사합니다." + ownerName + "님 " + money + "원 입금되었습니다. 입금 후 잔액은 " + balance + "입니다.");
	}

	public int withdraw(int money) {
		if (balance >= money) {
			balance -= money;
			System.out.println(ownerName + "님 " + money + "원 인출되었습니다. 인출 후 잔액은 " + balance + "입니다.");
			return money;
		} else {
			System.out.println(ownerName + "님 잔액이 부족하여 인출 실패하였습니다.");
			return 0;
		}
	}

	// getter, setter

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
