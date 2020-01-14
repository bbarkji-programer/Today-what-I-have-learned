package com.tj.ex06_product;

public class Product_main {
	public static void main(String[] args) {
//		System.out.println(Product.count);
		Product p1 = new Product("≥√¿Â∞Ì"); // p1.serialNo = 101
		Product p2 = new Product("≥√¿Â∞Ì"); // p2.serialNo = 102
		Product p3 = new Product("≥√¿Â∞Ì"); // p3.serialNo = 103
		
		System.out.println(p1.infoString());
		System.out.println(p2.infoString());
		System.out.println(p3.infoString());
	}
}
