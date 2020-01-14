package com.tj.ex12_book;

public class BookLib extends BookInfo implements ILendable {
	
	private String borrower;
	private String checkOutDate;
	private byte state; // 대출 중(1), 대출가능(0)
	
	public BookLib() {		
	}
	public BookLib(String bookNo, String bookTitle, String writer) {		
		super(bookNo, bookTitle, writer);
		state = STATE_NORMAL;		
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) {
			System.out.println(getBookTitle()+"은(는) 현재 대출 중입니다.");
			return;
		}
		// TODO Auto-generated method stub
	this.borrower = borrower;
	this.checkOutDate = checkOutDate;
	state = STATE_BORROWED;
	System.out.println(getBookTitle()+"이(가) 대출되었습니다. (대출일: "+checkOutDate+"),(대출인: "+borrower+")");
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookTitle()+"은(는) 이상하게도 대출 가능상태네요.");
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+"이(가) 반납되었습니다.");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo()+"\" "+getBookTitle()+"\" "+getWriter()+"는(은) 대출 가능합니다.");
		}else if(state == STATE_BORROWED) {
			System.out.println(getBookNo()+"\" "+getBookTitle()+"\" "+getWriter()+"는(은) 대출 중 입니다.");
			System.out.println("대출일: "+checkOutDate);
			System.out.println("대출인: "+borrower);
		}else {
			System.out.println(getBookNo()+"\" "+getBookTitle()+"\" 이상하네요. 예외상황이에요.");
		}
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
	

}
