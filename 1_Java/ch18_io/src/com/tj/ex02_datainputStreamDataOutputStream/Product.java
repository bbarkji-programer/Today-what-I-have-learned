package com.tj.ex02_datainputStreamDataOutputStream;

public class Product {
	private String name;
	private int price;
	private int ps;

	public Product(String name, int price, int ps) {
		this.name = name;
		this.price = price;
		this.ps = ps;
	}
	
	@Override
	public String toString() {
		return name+"\t"+price+"��\t"+ps+"��";
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	
}
