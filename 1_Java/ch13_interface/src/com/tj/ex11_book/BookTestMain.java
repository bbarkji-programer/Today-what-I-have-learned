package com.tj.ex11_book;

public class BookTestMain {
	public static void main(String[] args) {
		Book b = new Book("a01", "java", "ȫ�浿");
		ILendable iLendable = new ILendable() {

			@Override
			public void checkOut(String borrower, String checkOutDate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void checkIn() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void printState() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
