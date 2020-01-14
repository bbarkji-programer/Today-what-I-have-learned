package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_productMain {
	public static void main(String[] args) {
		// 1단계. x를 입력할 때 까지 재고 입력(물건명, 가격, 재고수량)받아 파일에 저장
		Scanner scanner = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/product.dat",true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("상품이 더 있나요?(중단을 원하면 X, 계속 진행하려면 아무 키나 눌러요~)");
				answer = scanner.next();
				if(answer.equalsIgnoreCase("x")) {
					break;
				}
				System.out.print("입력할 상품의 상품명은? ");
				dos.writeUTF(scanner.next());
				System.out.print("입력할 상품의 가격은? ");
				dos.writeInt(scanner.nextInt());
				System.out.println("입력할 상품의 재고량은? ");
				dos.writeInt(scanner.nextInt());
			}while(true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
