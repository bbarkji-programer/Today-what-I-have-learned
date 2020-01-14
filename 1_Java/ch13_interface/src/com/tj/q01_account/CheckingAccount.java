package com.tj.q01_account;

public class CheckingAccount extends Account {

	private String cardNo; // 체크카드번호
	private int amount; // 쓰는 돈

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) {
		if(this.cardNo.contentEquals(cardNo)) {
			if(amount > getBalance()) {
				System.out.println(getOwnerName()+"님 구매금액이 계좌잔액을 초과하여 결제가 되지 않습니다.");
				return 0;
			}else {		
				setBalance(getBalance()-amount);
				System.out.println(getOwnerName()+"님 "+amount+"원 사용(계좌잔액: "+getBalance()+"원)");
				return amount;
			}			
		}else {
			System.out.println("카드번호가 일치하지 않습니다.");
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
