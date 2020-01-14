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
			System.out.println("회원가입 하시겠습니까? (Y/N)");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("가입할 회원의 이름은?");
				name = scanner.next();
				System.out.println("가입할 회원의 전화번호는?");
				phone = scanner.next();
				scanner.nextLine(); // 버퍼에 남아있는 \n 지우는 용도
				System.out.println("가입할 회원의 주소는?");
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
