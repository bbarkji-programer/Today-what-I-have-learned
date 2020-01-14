package com.tj.ex11_book;

public class Book implements ILendable { // 인터페이스로부터 물려받음. implements

	// 필요정보 
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate; // <- Date로 가능
	private byte state; // 대출 중(1) or 대출가능(0)
	
	// 생성자
	// 1. 매개변수 없는 생성자
	public Book() {		
	}
	// 2. main 함수에서 Book b = new Book("450-01a", "java", "신용권") 이렇게 객체 만들 예정
	public Book(String bookNo, String bookTitle, String writer) {
		super(); // object 생성자(자동)
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
 		this.writer = writer;
		state = STATE_NORMAL; // 객체를 생성하면, 바로 이 상태.
	}
	
	// 메소드
	// 1. main 함수에서 b.checkOut("홍길동","12-06") 이렇게 호출 예정
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) { // <<- 여기서 예외발생
			System.out.println(bookTitle+"은(는) 현재 대출 중입니다.");
			return; // 그냥 아무것도 안 갖고 나를 호출한 곳으로 간다. (void니까 값을 못 가져감)
		}
	//대출 가능 상태이므로 대출 처리 진행(else 굳이 X)
	this.borrower = borrower;
	this.checkOutDate = checkOutDate; // <<- new Date
	state = STATE_BORROWED; // 대출 중 상태
	System.out.println(bookTitle+"이(가) 대출 되었습니다.");
	System.out.println("[대출일] "+checkOutDate); // <<- 심플데이트포맷으로 알아보게 바꾸기
	System.out.println("[대출인] "+borrower);
	}
	
	// b.checkIn() 이렇게 출력 예정
	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(bookTitle+"은(는) 대출 가능상태입니다. 그런데 좀 이상."); // <<- 여기서 강제 예외발생
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+"이(가) 반납되었습니다."); // <<-반납 전에 연체 여부 체크. 날짜 비교. 
	}
	
	// b.printState() => 840-0ㄱ "java" 신용권 저 대출 중 (대출일 12-06) 또는 대출 가능
	@Override
	public void printState() { // <<- toString 오버라이드
		if(state == STATE_NORMAL) {
			System.out.println(bookNo+" \""+bookTitle+"\" "+writer+"저 는(은) 대출 가능합니다."); // 화면에 " 출력하고 싶으면, \" 이렇게.
		}else if(state == STATE_BORROWED) {
			System.out.println(bookNo+" \""+bookTitle+"\" "+writer+"저 는(은) 대출 중 입니다.");
	        System.out.println("[대출일] "+checkOutDate); // <<- 심플데이트포맷
	        System.out.println("[대출인] "+borrower);
		}else {
			System.out.println(bookNo+" \""+bookTitle+"\" 이상하네요. 예외상황");
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
