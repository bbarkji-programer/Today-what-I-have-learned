package com.tj.book;

import java.sql.Date;

public class BookDto {
	private int book_id;
	private String book_title;
	private int book_price;
	private String book_image1;
	private String book_image2;
	private String book_content;
	private int book_discount;
	private Date book_rdate;
	
	public BookDto() {
	}

	public BookDto(int book_id, String book_title, int book_price, String book_image1, String book_image2,
			String book_content, int book_discount, Date book_rdate) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_price = book_price;
		this.book_image1 = book_image1;
		this.book_image2 = book_image2;
		this.book_content = book_content;
		this.book_discount = book_discount;
		this.book_rdate = book_rdate;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public String getBook_image1() {
		return book_image1;
	}

	public void setBook_image1(String book_image1) {
		this.book_image1 = book_image1;
	}

	public String getBook_image2() {
		return book_image2;
	}

	public void setBook_image2(String book_image2) {
		this.book_image2 = book_image2;
	}

	public String getBook_content() {
		return book_content;
	}

	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}

	public int getBook_discount() {
		return book_discount;
	}

	public void setBook_discount(int book_discount) {
		this.book_discount = book_discount;
	}

	public Date getBook_rdate() {
		return book_rdate;
	}

	public void setBook_rdate(Date book_rdate) {
		this.book_rdate = book_rdate;
	}

	@Override
	public String toString() {
		return "BookDto [book_id=" + book_id + ", book_title=" + book_title + ", book_price=" + book_price
				+ ", book_image1=" + book_image1 + ", book_image2=" + book_image2 + ", book_content=" + book_content
				+ ", book_discount=" + book_discount + ", book_rdate=" + book_rdate + "]";
	}
	
	
}
