package com.tj.q01_account;

public class CheckingAccount extends Account {

	private String cardNo; // üũī���ȣ
	private int amount; // ���� ��

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) {
		if(this.cardNo.contentEquals(cardNo)) {
			if(amount > getBalance()) {
				System.out.println(getOwnerName()+"�� ���űݾ��� �����ܾ��� �ʰ��Ͽ� ������ ���� �ʽ��ϴ�.");
				return 0;
			}else {		
				setBalance(getBalance()-amount);
				System.out.println(getOwnerName()+"�� "+amount+"�� ���(�����ܾ�: "+getBalance()+"��)");
				return amount;
			}			
		}else {
			System.out.println("ī���ȣ�� ��ġ���� �ʽ��ϴ�.");
			return 0;
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
