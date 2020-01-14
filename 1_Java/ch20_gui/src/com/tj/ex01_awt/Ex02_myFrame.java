package com.tj.ex01_awt;

//import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
//import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02_myFrame extends Frame implements ActionListener { // ActionListener �� �̺�Ʈó��
	// ������Ʈ ���� ����
	private Label lbl01;
	private Button btnExit;
	// ������ - ȭ�鱸��
	public Ex02_myFrame(String name) {
		super(name);
//		setLayout(new BorderLayout()); // ���� �⺻. �ƹ��͵� �Ⱦ��� �̰�.
//		setLayout(new GridLayout(1,2)); // 1�� 2�� ¥�� �׸��� ���̾ƿ�
		setLayout(new FlowLayout()); // ���ʺ��� ��������~
		lbl01 = new Label("Happy Tuesday");
		btnExit = new Button("EXIT");
		lbl01.setPreferredSize(new Dimension(250,200));
		btnExit.setPreferredSize(new Dimension(200,200));
		add(lbl01);
		add(btnExit);
		setSize(new Dimension(500,300));
		setBackground(Color.GREEN);
		setLocation(100,50);
		setVisible(true);
		btnExit.addActionListener(this); // �̺�Ʈ ó���� �ſ�. �̺�Ʈ�� ������������ �� �ڽ�(this)�ȿ� �ִ� actionPerformed ȣ��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex02_myFrame () {
		this("");
	}
	// �̺�Ʈó�� - Ŭ�� �� ���ض�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex02_myFrame("The second example");
	}
}