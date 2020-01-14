package com.tj.ex12_book;

public class BookLib extends BookInfo implements ILendable {
	
	private String borrower;
	private String checkOutDate;
	private byte state; // ���� ��(1), ���Ⱑ��(0)
	
	public BookLib() {		
	}
	public BookLib(String bookNo, String bookTitle, String writer) {		
		super(bookNo, bookTitle, writer);
		state = STATE_NORMAL;		
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) {
			System.out.println(getBookTitle()+"��(��) ���� ���� ���Դϴ�.");
			return;
		}
		// TODO Auto-generated method stub
	this.borrower = borrower;
	this.checkOutDate = checkOutDate;
	state = STATE_BORROWED;
	System.out.println(getBookTitle()+"��(��) ����Ǿ����ϴ�. (������: "+checkOutDate+"),(������: "+borrower+")");
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookTitle()+"��(��) �̻��ϰԵ� ���� ���ɻ��³׿�.");
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+"��(��) �ݳ��Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo()+"\" "+getBookTitle()+"\" "+getWriter()+"��(��) ���� �����մϴ�.");
		}else if(state == STATE_BORROWED) {
			System.out.println(getBookNo()+"\" "+getBookTitle()+"\" "+getWriter()+"��(��) ���� �� �Դϴ�.");
			System.out.println("������: "+checkOutDate);
			System.out.println("������: "+borrower);
		}else {
			System.out.println(getBookNo()+"\" "+getBookTitle()+"\" �̻��ϳ׿�. ���ܻ�Ȳ�̿���.");
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
