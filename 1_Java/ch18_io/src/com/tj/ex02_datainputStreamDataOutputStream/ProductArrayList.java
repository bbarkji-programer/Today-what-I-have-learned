package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductArrayList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>(); // 몇개가 추가될 지 모르니까 ArrayList로 받기.		
		InputStream fis = null; // 기본스트림 변수
		DataInputStream dis = null; // 보조스트림 변수
		String name;
		int price;
		int ps;
		try {
			fis = new FileInputStream("txtFile/product.dat"); // 기본스트림 열기
			dis = new DataInputStream(fis); // 기본스트림 이용해 보조스트림 열기
			while(true) {
				name = dis.readUTF(); // 상품명
				price = dis.readInt(); // 가격
				ps = dis.readInt(); // 재고량	
				// 가져온 1세트 재고량을 products에 추가
				products.add(new Product(name,price,ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("product.dat 파일 내용을 arrayList에 담기 끝");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();				
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("이상 "+products.size()+"개 상품 입력완료.");
	}
}
