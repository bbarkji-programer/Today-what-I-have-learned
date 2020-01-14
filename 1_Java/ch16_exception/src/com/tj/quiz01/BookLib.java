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
			throw new Exception(bookTitle+"("+writer+" ��)��(��) ���� ������ �Ұ����մϴ�.");
		}
		this.borrower = borrower;
		Date checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.println(bookTitle+"("+writer+" ��)��(��) �����մϴ�.");
		System.out.println("[������] "+borrower);
		SimpleDateFormat cod = new SimpleDateFormat("yyyy�� MM�� dd�� E����");
		System.out.println("[������] "+cod.format(checkOutDate));		
	}
	@Override
	public void checkIn() throws Exception {
		if(state!=STATE_BORROWED) { // ���� ���� üũ
			throw new Exception(bookTitle+"("+writer+" ��)��(��) ���� ��Ȳ ����. ����ũ�� ���ǹٶ��ϴ�.");
		}
		Date checkInDate = new Date();
		long borrowedMillis =checkInDate.getTime() - checkOutDate.getTime(); // ���� �Ⱓ �и�����
		long borrowedDays = borrowedMillis/(24*60*60*1000); // ���� �Ⱓ ��
		if(borrowedDays>14) {
			System.out.println((borrowedDays-14)*100+"�� ��ü�Ḧ ���ž� �ݳ�ó�� �����մϴ�.");
			Scanner sc = new Scanner(System.in);
			System.out.println("��ü�Ḧ �����̳���? (N:�ݳ�ó�� �ߴ�, Y:�ݳ�ó�� ����)");
			String answer = sc.nextLine();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �˴ϴ�.");
				return;
			}//if
		}//if
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+"("+writer+" ��)��(��) �ݳ��մϴ�.");		
	}
	@Override
	public String toString() {
		String temp = bookNo+" \""+bookTitle+"\" "+writer+"�� ";
		if(state == STATE_NORMAL) {
			temp += "���Ⱑ��";
		}else if(state==STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E");
			temp += "������("+sdf.format(checkOutDate)+")";
		}else {
			temp += " �̻��ϴ�. ���ܻ�Ȳ";
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
