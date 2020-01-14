package com.tj.ex05_account;

public class Account {

	// �ʿ��� ������
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������
	private int balance; // �ܾ�

	// Account park = new Account() ������ -> setter �ʿ�
	public Account() {
		System.out.println("�Ű������� ���� ������");
	}

	// Account park = new Account("111-111","������") ������
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	// Account park = new Account("111-111","������",1000) ������
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// ���(�޼ҵ�)
	public void deposit(int money) {
		balance += money;
		System.out.println("�����մϴ�." + ownerName + "�� " + money + "�� �ԱݵǾ����ϴ�. �Ա� �� �ܾ��� " + balance + "�Դϴ�.");
	}

	public int withdraw(int money) {
		if (balance >= money) {
			balance -= money;
			System.out.println(ownerName + "�� " + money + "�� ����Ǿ����ϴ�. ���� �� �ܾ��� " + balance + "�Դϴ�.");
			return money;
		} else {
			System.out.println(ownerName + "�� �ܾ��� �����Ͽ� ���� �����Ͽ����ϴ�.");
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
