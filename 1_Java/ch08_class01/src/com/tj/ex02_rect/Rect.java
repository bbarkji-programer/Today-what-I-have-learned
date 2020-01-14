package com.tj.ex02_rect;

public class Rect {
	//���� ����
	private int width;
	private int height;
	//������(main�Լ��� new���� ������ŭ �ʿ�)
	public Rect() { //default ������
	}
	public Rect(int side) { //�Ű� ������ �ϳ��� ���
		width=height=side;
	}
	public Rect(int width, int height) { //�Ű� ������ �ΰ��� ���
		this.width = width;
		this.height = height;
	}
	//�̰� ��(���ప) 
	public int area() {
		return width*height;
	}
	//setter, getter
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}	
}
