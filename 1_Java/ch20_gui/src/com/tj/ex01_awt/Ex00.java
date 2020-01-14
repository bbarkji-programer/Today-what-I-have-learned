package com.tj.ex01_awt;

import java.awt.*;

public class Ex00 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("button");
		frame.add(btn); // â ���� ��ư�� �ö󰣴�.
		Button btn2 = new Button("2nd button");
		frame.add(btn2);
		frame.setSize(new Dimension(300,200)); // â ������ - ���� 300 �ȼ�, ���� 200 �ȼ�
//		frame.pack(); //�ּ����� ������
		frame.setBackground(Color.GREEN);
		frame.setLocation(800, 400); // â ��ġ - ���� 100, ���� 50 ���
		frame.setVisible(true); // �������� â�� ���̰�
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false); // ȭ�鿡 �Ⱥ��̰� 
		frame.dispose(); // �ڿ�����
		System.exit(0); // ��������
	} 
}
