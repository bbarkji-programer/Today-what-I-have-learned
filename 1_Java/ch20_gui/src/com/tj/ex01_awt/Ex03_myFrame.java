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
//		lbl01 = new Label("아 이 디");
//		lbl02 = new Label("비밀번호");
		txtID = new TextField("ID",20); // 텍스트필드에 표기, 20글자 입력 가능
		txtPW = new TextField(20); // 텍스트 필드에 표기하기 싫으면 앞에 "PW"빼면 됨
			txtPW.setEchoChar('*'); // 입력할 때 * 로 보이게 한다.
		btn = new Button("로그인");
		
		panel.add(new Label("아이디",(int)CENTER_ALIGNMENT)); // 1행 1열
		panel.add(txtID); // 1행 2열
		panel.add(new Label("비밀번호",(int)CENTER_ALIGNMENT)); // 2행 1열
		panel.add(txtPW);// 2행 2열
		
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
