package com.tj.q01_account;

public class Account {

	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {		
	}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println(ownerName+"님 계좌("+accountNo+")에 "+amount+"원 입금. 입금 후 잔액은 "+balance+"원 입니다.");
	}
	public int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			System.out.println(ownerName+"님 계좌("+accountNo+")에 "+amount+"원 출금. 출금 후 잔액은 "+balance+"원 입니다.");
			return amount;
		}else {
			System.out.println(ownerName+"님 계좌("+accountNo+")에 잔액이 부족하여 인출 실패하였습니다.");
			return 0;
		}	
	}//withdraw
	
	public void printAccount() {
		System.out.println("계좌번호: "+accountNo);
		System.out.println("예금주: "+ownerName);
		System.out.println("잔액: "+balance);
	}
	
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
