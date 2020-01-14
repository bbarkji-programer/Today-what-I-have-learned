package com.tj.quiz01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) throws Exception {
		
		BookLib[] books = {new BookLib("890-01", "java", "�ſ��"),
				new BookLib("890-02", "dbms", "����"),
				new BookLib("890-03", "html", "�ڿ��"),
				new BookLib("890-04", "css", "�ֿ��"),
				new BookLib("890-05", "jsp", "�̿��")};
		
		Scanner sc = new Scanner(System.in);	
		
		String bookTitle2;
		String borrower;
		int idx;
		int fn;// ��ɹ�ȣ
		
		do {
			System.out.print("[0]���� ���� ���� [1]����, [2]�ݳ� (*0,1,2 �� �ٸ� �Է� �� �����մϴ�.)");
			try {
				fn = sc.nextInt();				
			} catch (Exception e) {
				System.out.println("0,1,2 �� �ٸ� �Է� �� �����մϴ�.");
				break;
			}
			switch(fn) {
			case 0:
				System.out.println("���� ���� ��Ȳ�Դϴ�.");
				for(BookLib book : books) {
					System.out.println(book);
				}
				break;
			case 1:
				System.out.println("�����ϰ��� �ϴ� å �̸���?");
				sc.nextLine();
				bookTitle2 = sc.nextLine();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bookTitle2)) {
						break;						
					}
				}			
				if(idx==books.length) {
					System.out.println("�츮 ���������� ���� �����Դϴ�.");
				}else {
					if(books[idx].getState()==BookLib.STATE_BORROWED) {
						System.out.println("���� ���� ���Դϴ�.");
					}else {
						System.out.print("������ �̸�: ");
						borrower = sc.next();
						try {
							books[idx].checkOut(borrower);// (5)����ó��
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}											
					}
				}
				break;
			case 2: // �ݳ�ó�� ����
				System.out.print("�ݳ��ϰ��� �ϴ� å �̸��� �Է����ּ���.");
				sc.nextLine();
				bookTitle2 = sc.nextLine();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bookTitle2)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("�� ������ �츮 ������ �弭�� �ƴմϴ�.");
				}else {
					try {
						books[idx].checkIn();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}								
				break;
			default:
				System.out.println("*0,1,2 �� �ٸ� �Է� �� �����մϴ�.");
			}
		}while(fn==0 || fn==1 || fn==2);
		System.out.println("�ȳ��� ������.");
	}
}
