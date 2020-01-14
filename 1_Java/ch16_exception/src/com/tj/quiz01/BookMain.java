package com.tj.quiz01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) throws Exception {
		
		BookLib[] books = {new BookLib("890-01", "java", "신용권"),
				new BookLib("890-02", "dbms", "김용권"),
				new BookLib("890-03", "html", "박용권"),
				new BookLib("890-04", "css", "최용권"),
				new BookLib("890-05", "jsp", "이용권")};
		
		Scanner sc = new Scanner(System.in);	
		
		String bookTitle2;
		String borrower;
		int idx;
		int fn;// 기능번호
		
		do {
			System.out.print("[0]대출 상태 열람 [1]대출, [2]반납 (*0,1,2 외 다른 입력 시 종료합니다.)");
			try {
				fn = sc.nextInt();				
			} catch (Exception e) {
				System.out.println("0,1,2 외 다른 입력 시 종료합니다.");
				break;
			}
			switch(fn) {
			case 0:
				System.out.println("대출 상태 현황입니다.");
				for(BookLib book : books) {
					System.out.println(book);
				}
				break;
			case 1:
				System.out.println("대출하고자 하는 책 이름은?");
				sc.nextLine();
				bookTitle2 = sc.nextLine();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bookTitle2)) {
						break;						
					}
				}			
				if(idx==books.length) {
					System.out.println("우리 도서관에는 없는 도서입니다.");
				}else {
					if(books[idx].getState()==BookLib.STATE_BORROWED) {
						System.out.println("현재 대출 중입니다.");
					}else {
						System.out.print("대출자 이름: ");
						borrower = sc.next();
						try {
							books[idx].checkOut(borrower);// (5)대출처리
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}											
					}
				}
				break;
			case 2: // 반납처리 시작
				System.out.print("반납하고자 하는 책 이름을 입력해주세요.");
				sc.nextLine();
				bookTitle2 = sc.nextLine();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bookTitle2)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("이 도서는 우리 도서관 장서가 아닙니다.");
				}else {
					try {
						books[idx].checkIn();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}								
				break;
			default:
				System.out.println("*0,1,2 외 다른 입력 시 종료합니다.");
			}
		}while(fn==0 || fn==1 || fn==2);
		System.out.println("안녕히 가세요.");
	}
}
