package com.tj.quiz01;

public interface ILendable {

	public String STATE_BORROWED = "대출불 가능"; // 대출 불가능
	public String STATE_NORMAL = "대출 가능"; // 대출 가능
	
	public void checkOut(String borrower) throws Exception; // 대출 시
	public void checkIn() throws Exception; // 반납 시 
	
}
