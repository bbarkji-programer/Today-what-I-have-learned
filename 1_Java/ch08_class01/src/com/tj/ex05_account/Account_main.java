package com.tj.ex05_account;

public class Account_main {
	public static void main(String[] args) {

		Account park = new Account("123-456", "������", 20000);
		Account park1 = new Account("567-890", "������1");
		Account park2 = new Account();
		park2.setAccountNo("111-222");
		park2.setOwnerName("������2");

		park.deposit(10000);
		park1.deposit(10000);
		park2.deposit(10000);

		int result = park.withdraw(40000);
		if (result == 0) {
		}
		result = park2.withdraw(5000);
		if (result == 0) {
		}
	}
}
