package com.tj.ex07_homework;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name, phone, birth, address;
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(date);
		
			do {
				System.out.print("ȸ������ ������ �Է��մϴ�. ���Ḧ ���ϸ� N Ű��, ��� ������ ���ϸ� �ƹ� Ű�� �����ּ���.");
				if((scanner.next()).equalsIgnoreCase("n")) {
					break;
				}else {
					System.out.print("ȸ�� �̸���?");
					name = scanner.next();
					System.out.println("ȸ�� ��ȭ��ȣ��?");
					phone = scanner.next();
					System.out.println("ȸ�� ������?(��:01-08)");
					birth = scanner.next();									
					System.out.println("ȸ�� �ּҴ�?");
					scanner.nextLine();
					address = scanner.nextLine();
					if(birth.equals(todayStr)) {
						System.out.println("���� �����̽ó׿�. ���� ���� �����~!");
					}
					customers.add(new Customer(name, phone, birth, address));
				}
			}while(true);
			
			Writer writer  = null;
			try {
				writer = new FileWriter("src/com/tj/ex07_homework/customer.txt",true);
				for(Customer c : customers) {
					System.out.print(c);
					writer.write(c.toString());
				}
				String msg = "......���� "+customers.size()+"�� ����";
				System.out.println(msg);
				writer.write(msg);
				} catch (FileNotFoundException e) {
					System.out.println("���ϸ�ã��"+e.getMessage());
				} catch (IOException e) {
					System.out.println("�������"+e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally		
		}//main		
	}//class
