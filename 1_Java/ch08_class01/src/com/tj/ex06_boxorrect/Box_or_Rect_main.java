package com.tj.ex06_boxorrect;

public class Box_or_Rect_main {
	public static void main(String[] args) {
		Box_or_Rect box = new Box_or_Rect(5, 6, 10);
		Box_or_Rect rect = new Box_or_Rect(5, 6);

		box.calVolume();
		rect.calVolume();

		System.out.println("����: " + box.getWidth() + ", ����: " + box.getHeight() + ", ����: " + box.getDepth()
				+ "�� �ڽ��� ���Ǵ� " + box.getVolume() + "������ ��Ƽ���� �Դϴ�.");
		System.out.println("����: " + rect.getWidth() + ", ����: " + rect.getHeight() 
				+ "�� ���簢���� ���̴� " + rect.getVolume() + "������Ƽ���� �Դϴ�.");
	}
}
