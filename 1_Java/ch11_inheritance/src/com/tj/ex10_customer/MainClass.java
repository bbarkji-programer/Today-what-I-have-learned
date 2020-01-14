package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class MainClass {
	public static void main(String[] args) {
		Customer customer = new Customer("ȫ�浿", "9999-9999", "����� ���α�", "12-04");
		customer.buy(10000);
		Staff staff = new Staff("ȫ�ϲ�", "8888-8888", "2019-11-01", "�����");
		Person[] person = {customer, staff};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		Person customer1 = new Customer("����", "7777-7777", "����� ������", "11-04");
		System.out.println(customer1.infoString());
		if(customer1 instanceof Customer) {
		((Customer)customer1).buy(10000); // Customer�� �� ��ȯ
		}
		Constant.RATE = 0.07;
	}
}
