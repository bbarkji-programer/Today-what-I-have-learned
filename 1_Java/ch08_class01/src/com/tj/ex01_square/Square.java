package com.tj.ex01_square;
public class Square {
	private int side;
	public Square() {   //default ������
		System.out.println("�Ű� ���� ���� ������ �Լ��� ȣ��");
	}
	public Square(int side) {
		this.side = side;
		System.out.println("�Ű� ���� �ִ� ������ �Լ��� ȣ��");
	}
	public int area() {
		return side*side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
