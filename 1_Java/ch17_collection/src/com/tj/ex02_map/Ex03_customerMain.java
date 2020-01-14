package com.tj.ex02_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import com.tj.ex01_list.Customer;

public class Ex03_customerMain extends Customer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		
		do {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�? (Y/N)");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("������ ȸ���� �̸���?");
				name = scanner.next();
				System.out.println("������ ȸ���� ��ȭ��ȣ��?");
				phone = scanner.next();
				scanner.nextLine(); // ���ۿ� �����ִ� \n ����� �뵵
				System.out.println("������ ȸ���� �ּҴ�?");
				address = scanner.nextLine();	
				customers.put(phone, new Customer(name, phone, address));
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(customers.get(iterator.next()));
		}
	}
}
