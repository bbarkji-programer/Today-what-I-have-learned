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
				System.out.print("회원가입 정보를 입력합니다. 종료를 원하면 N 키를, 계속 진행을 원하면 아무 키나 눌러주세요.");
				if((scanner.next()).equalsIgnoreCase("n")) {
					break;
				}else {
					System.out.print("회원 이름은?");
					name = scanner.next();
					System.out.println("회원 전화번호는?");
					phone = scanner.next();
					System.out.println("회원 생일은?(예:01-08)");
					birth = scanner.next();									
					System.out.println("회원 주소는?");
					scanner.nextLine();
					address = scanner.nextLine();
					if(birth.equals(todayStr)) {
						System.out.println("오늘 생일이시네요. 생일 축하 드려요~!");
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
				String msg = "......이하 "+customers.size()+"명 가입";
				System.out.println(msg);
				writer.write(msg);
				} catch (FileNotFoundException e) {
					System.out.println("파일못찾음"+e.getMessage());
				} catch (IOException e) {
					System.out.println("쓰기오류"+e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally		
		}//main		
	}//class
