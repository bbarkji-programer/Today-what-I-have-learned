package com.tj.ex04_object;

public class GoodsMain {

	public static void main(String[] args) {
		
		Goods[] goods = {new Goods("a01", "�����", 1500, 10),
						new Goods("a02", "���ĸ�", 1300, 10)};
		Customer[] customers = {new Customer("010-0000-0000", "ȫ�浿", "01-11"),
				new Customer("010-1111-11111", "��浿", "12-11")};
		for(Goods good : goods) {
			System.out.println(good.toString());
		}
		for(Customer customer : customers) {
			System.out.println(customer); //customer.toString()
		}
		
	}
}
