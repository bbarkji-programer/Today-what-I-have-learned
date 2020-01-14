package com.tj.ex01_string;
// String ������ ����� ���
public class Ex10_StringBuilder {

	public static void main(String[] args) {
		
		StringBuilder strBuilder = new StringBuilder("abc");
		StringBuffer strBuffer = new StringBuffer("abc");
		
		strBuilder.append("def"); // abcdef
		System.out.println(strBuilder);
		
		strBuilder.insert(3, "AAA"); //abcAAAdef
		System.out.println(strBuilder);
		
		strBuilder.delete(3, 5); // (i,j) i���� j�ձ��� ���� -> abcAdef
		System.out.println(strBuilder);
		
		strBuilder.deleteCharAt(3); // 3��°�� ����� �;� -> abcdef
		System.out.println(strBuilder);
		
		int capacitySize = strBuilder.capacity(); // ������ ����ũ��
		System.out.println("������ ����ũ�� : "+capacitySize);
		
		strBuilder.append("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.out.println(strBuilder);
		capacitySize = strBuilder.capacity();
		System.out.println("���� ������ ����ũ�� : "+capacitySize);
	}
}
