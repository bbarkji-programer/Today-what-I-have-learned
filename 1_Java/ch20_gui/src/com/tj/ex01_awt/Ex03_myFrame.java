package com.tj.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03_myFrame extends Frame {
	private Panel panel;
	private Button btn;
	private Label lbl01, lbl02;
	private TextField txtID, txtPW;
	
	public Ex03_myFrame(String title) {
		super(title);
		panel = new Panel();
			panel.setLayout(new GridLayout(2,2));
//		lbl01 = new Label("�� �� ��");
//		lbl02 = new Label("��й�ȣ");
		txtID = new TextField("ID",20); // �ؽ�Ʈ�ʵ忡 ǥ��, 20���� �Է� ����
		txtPW = new TextField(20); // �ؽ�Ʈ �ʵ忡 ǥ���ϱ� ������ �տ� "PW"���� ��
			txtPW.setEchoChar('*'); // �Է��� �� * �� ���̰� �Ѵ�.
		btn = new Button("�α���");
		
		panel.add(new Label("���̵�",(int)CENTER_ALIGNMENT)); // 1�� 1��
		panel.add(txtID); // 1�� 2��
		panel.add(new Label("��й�ȣ",(int)CENTER_ALIGNMENT)); // 2�� 1��
		panel.add(txtPW);// 2�� 2��
		
		add(panel, BorderLayout.NORTH);
		add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(new Dimension(400,200));
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex03_myFrame() {
		this("");
	}
	public static void main(String[] args) {
		new Ex03_myFrame("Third Example");
	}
	
	
}
