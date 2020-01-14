package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductArrayList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>(); // ��� �߰��� �� �𸣴ϱ� ArrayList�� �ޱ�.		
		InputStream fis = null; // �⺻��Ʈ�� ����
		DataInputStream dis = null; // ������Ʈ�� ����
		String name;
		int price;
		int ps;
		try {
			fis = new FileInputStream("txtFile/product.dat"); // �⺻��Ʈ�� ����
			dis = new DataInputStream(fis); // �⺻��Ʈ�� �̿��� ������Ʈ�� ����
			while(true) {
				name = dis.readUTF(); // ��ǰ��
				price = dis.readInt(); // ����
				ps = dis.readInt(); // ���	
				// ������ 1��Ʈ ����� products�� �߰�
				products.add(new Product(name,price,ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("product.dat ���� ������ arrayList�� ��� ��");
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
		System.out.println("�̻� "+products.size()+"�� ��ǰ �Է¿Ϸ�.");
	}
}
