package com.tj.ex12_book;
import java.util.Scanner;
public class BookMain01 {

	public static void main(String[] args) {
		
		BookLib[] books = {new BookLib("890-01", "java", "신용권"),
				new BookLib("890-02", "dbms", "김용권"),
				new BookLib("890-03", "html", "박용권"),
				new BookLib("890-04", "css", "최용권"),
				new BookLib("890-05", "jsp", "이용권")};
		
		Scanner sc = new Scanner(System.in);
		// 필요한 변수
		String bTitle; // 입력할 책 제목
		int idx; // 대출이나 반납을 처리할 책의 index
		String borrower, checkOutDate; // 빌린사람이랑 대출일
		int fn; // 기능번호
		
		for(BookLib book : books) {
			book.printState();
		}	
		
		// 대출을 원하는지, 반납을 원하는지 반드시 한 번은 물어봐야 하니까 Do While문		
		do {
			System.out.print("[1]도서 대출, [2]도서 반납, [0]종료");
			fn = sc.nextInt();
			switch(fn){
			case 1: // 대출처리
				// 1. 책 이름 입력받기
				System.out.print("대출하고자 하는 책 이름은: ");
				bTitle = sc.next(); // white-space 앞 까지의 스트링을 받음.
				// 2. 책이 배열에 있는지 검색
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) { // 객체니까 == 아니고 equals(값)
						break; 
					}
				}
				// idx<books.length 경우 찾았다. idx==books.length의 경우는 못 찾은 경우가 됨.
				if(idx==books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");
				}else {
					// 3. 책 상태 확인
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출 중인 도서입니다.");
					}else {
						// 4. 대출자 입력
						System.out.println("대출자 이름은: ");
						borrower = sc.next();
						// 5. 대출일 입력
						System.out.println("대출일(오늘날짜)은: (예:12-06) ");
						checkOutDate = sc.next();
						// 6. 대출
						books[idx].checkOut(borrower, checkOutDate);
					
					}
					break;	
				}		
			case 2: // 반납처리
				// 1. 책 이름 입력받기
				System.out.print("반납하고자 하는 책 이름은: ");
				bTitle = sc.next();
				// 2. 책(이 배열에 있는지) 검색
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("이 도서는 본 도서관 장서가 아닙니다.");
				}else {
					//3. 반납
					books[idx].checkIn();

				}
				break;
			case 0 :
				break;
			default:
				System.out.println("유효하지 않은 기능번호입니다.");
			}		
		}while(fn!=0);
		
		for(BookLib book : books) {
			book.printState();
		}
		
		System.out.println("안녕히 가세요.");
		sc.close();
	}
}
