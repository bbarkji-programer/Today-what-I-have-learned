package com.tj.quiz01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkOutDate;
	private String state;
	
	public BookLib() {		
	}
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}	
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state!=STATE_NORMAL) {
			throw new Exception(bookTitle+"("+writer+" 저)은(는) 현재 대출이 불가능합니다.");
		}
		this.borrower = borrower;
		Date checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.println(bookTitle+"("+writer+" 저)을(를) 대출합니다.");
		System.out.println("[대출인] "+borrower);
		SimpleDateFormat cod = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		System.out.println("[대출일] "+cod.format(checkOutDate));		
	}
	@Override
	public void checkIn() throws Exception {
		if(state!=STATE_BORROWED) { // 도서 상태 체크
			throw new Exception(bookTitle+"("+writer+" 저)은(는) 대출 현황 오류. 데스크에 문의바랍니다.");
		}
		Date checkInDate = new Date();
		long borrowedMillis =checkInDate.getTime() - checkOutDate.getTime(); // 빌린 기간 밀리세컨
		long borrowedDays = borrowedMillis/(24*60*60*1000); // 빌린 기간 일
		if(borrowedDays>14) {
			System.out.println((borrowedDays-14)*100+"원 연체료를 내셔야 반납처리 진행합니다.");
			Scanner sc = new Scanner(System.in);
			System.out.println("연체료를 받으셨나요? (N:반납처리 중단, Y:반납처리 진행)");
			String answer = sc.nextLine();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("연체료를 내셔야 반납처리가 됩니다.");
				return;
			}//if
		}//if
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+"("+writer+" 저)을(를) 반납합니다.");		
	}
	@Override
	public String toString() {
		String temp = bookNo+" \""+bookTitle+"\" "+writer+"저 ";
		if(state == STATE_NORMAL) {
			temp += "대출가능";
		}else if(state==STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E");
			temp += "대출중("+sdf.format(checkOutDate)+")";
		}else {
			temp += " 이상하다. 예외상황";
		}
		return temp;

	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
