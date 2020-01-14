package com.tj.ex11_book;

public class Book implements ILendable { // �������̽��κ��� ��������. implements

	// �ʿ����� 
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate; // <- Date�� ����
	private byte state; // ���� ��(1) or ���Ⱑ��(0)
	
	// ������
	// 1. �Ű����� ���� ������
	public Book() {		
	}
	// 2. main �Լ����� Book b = new Book("450-01a", "java", "�ſ��") �̷��� ��ü ���� ����
	public Book(String bookNo, String bookTitle, String writer) {
		super(); // object ������(�ڵ�)
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
 		this.writer = writer;
		state = STATE_NORMAL; // ��ü�� �����ϸ�, �ٷ� �� ����.
	}
	
	// �޼ҵ�
	// 1. main �Լ����� b.checkOut("ȫ�浿","12-06") �̷��� ȣ�� ����
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) { // <<- ���⼭ ���ܹ߻�
			System.out.println(bookTitle+"��(��) ���� ���� ���Դϴ�.");
			return; // �׳� �ƹ��͵� �� ���� ���� ȣ���� ������ ����. (void�ϱ� ���� �� ������)
		}
	//���� ���� �����̹Ƿ� ���� ó�� ����(else ���� X)
	this.borrower = borrower;
	this.checkOutDate = checkOutDate; // <<- new Date
	state = STATE_BORROWED; // ���� �� ����
	System.out.println(bookTitle+"��(��) ���� �Ǿ����ϴ�.");
	System.out.println("[������] "+checkOutDate); // <<- ���õ���Ʈ�������� �˾ƺ��� �ٲٱ�
	System.out.println("[������] "+borrower);
	}
	
	// b.checkIn() �̷��� ��� ����
	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(bookTitle+"��(��) ���� ���ɻ����Դϴ�. �׷��� �� �̻�."); // <<- ���⼭ ���� ���ܹ߻�
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+"��(��) �ݳ��Ǿ����ϴ�."); // <<-�ݳ� ���� ��ü ���� üũ. ��¥ ��. 
	}
	
	// b.printState() => 840-0�� "java" �ſ�� �� ���� �� (������ 12-06) �Ǵ� ���� ����
	@Override
	public void printState() { // <<- toString �������̵�
		if(state == STATE_NORMAL) {
			System.out.println(bookNo+" \""+bookTitle+"\" "+writer+"�� ��(��) ���� �����մϴ�."); // ȭ�鿡 " ����ϰ� ������, \" �̷���.
		}else if(state == STATE_BORROWED) {
			System.out.println(bookNo+" \""+bookTitle+"\" "+writer+"�� ��(��) ���� �� �Դϴ�.");
	        System.out.println("[������] "+checkOutDate); // <<- ���õ���Ʈ����
	        System.out.println("[������] "+borrower);
		}else {
			System.out.println(bookNo+" \""+bookTitle+"\" �̻��ϳ׿�. ���ܻ�Ȳ");
		}
	}
	
	//getter, setter
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
