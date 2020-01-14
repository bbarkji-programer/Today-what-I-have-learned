package com.tj.ex12_book;
// 인터페이스에는 1. 상수 2. 추상메소드 만.
public interface ILendable {

	//공통 필요 정보
	public byte STATE_BORROWED = 1; // (상수) 대출 불가능 상태(=대출 중)
	public byte STATE_NORMAL = 0; // (상수) 대출 가능 상태
	
	public void checkOut(String borrower, String checkOutDate); // (추상메소드) 대출 시
	public void checkIn(); // (추상메소드) 반납 시
	public void printState(); // (추상메소드) 도서정보와 현재 상태 출력 ex) 이것이 자바다 신용권 저 대출 중
	
}
