package com.tj.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex01_myFrame extends Frame {
	
	////// ������Ʈ ���� ����. �̺�Ʈ ó���ϴ� �޼ҵ尡 ���� �����ϱ�, ���� ������ ���� ����� �Ѵ�.
	private Button btn, btn2;
	
	public Ex01_myFrame(String title) {
		super(title); // super�� �� ����
		////// ȭ�鱸��
		btn = new Button("button");
		btn2 = new Button("button2");
		setLayout(new FlowLayout()); // FlowLayout() : add ������� ������Ʈ�� �������� �߰�
		add(btn);
		add(btn2);
//		setLayout(new BorderLayout()); //�⺻ ���̾ƿ� BorderLayout(south, nortn, west, east, center)
//		add(btn, BorderLayout.WEST); //���ʿ� �߰�
//		add(btn2, BorderLayout.CENTER);
		setSize(new Dimension(300,200));
		setLocation(100,50);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // x ��ư ������ ����ǰ�
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

	}	
	public Ex01_myFrame() {
		this("");
	}
	public static void main(String[] args) {
		new Ex01_myFrame("The first example");
	}
	////// �̺�Ʈ ó���ϴ� �޼ҵ�� ����
}
