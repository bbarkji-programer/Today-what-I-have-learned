package com.tj.ex04_account;

public class AccountMain {
	public static void main(String[] args) {
		
		Account ob1 = new Account("11112222-3333","ȫ");
		Account ob2 = new Account("2221111-3333", "��", 10000);
		ob1.deposit(10000);
		ob2.deposit(10000);
		try {
			ob1.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ob2.withdraw(30000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
