package com.tj.ex04_object;

public class Ex06_RectMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle (5, 6, "#FF0000"); // ��/��/��
		Rectangle r2 = (Rectangle)r1.clone();
		System.out.println(r1);
		System.out.println(r2);
		if(r1==r2) { // �ּҰ� ������?
			System.out.println("������ �� �ƴϰ�, ���� ��ü�� ��(=�ּ� ����)"); //true
		}else {
			System.out.println("������ �߳�. �ٸ� ��ü�� ��(=�ּ� �ٸ�)"); // false
		}
		if(r1.equals(r2)) { // ������ ������?
			System.out.println("���� �簢��"); // true
		}else {
			System.out.println("�ٸ� �簢��"); //false
		}
	}
}
