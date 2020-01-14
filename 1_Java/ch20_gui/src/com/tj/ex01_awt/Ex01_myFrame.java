package com.tj.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex01_myFrame extends Frame {
	
	////// 컴포넌트 변수 선언. 이벤트 처리하는 메소드가 따로 빠지니까, 변수 선언을 위에 해줘야 한다.
	private Button btn, btn2;
	
	public Ex01_myFrame(String title) {
		super(title); // super가 젤 위에
		////// 화면구현
		btn = new Button("button");
		btn2 = new Button("button2");
		setLayout(new FlowLayout()); // FlowLayout() : add 순서대로 컴포넌트가 차곡차곡 추가
		add(btn);
		add(btn2);
//		setLayout(new BorderLayout()); //기본 레이아웃 BorderLayout(south, nortn, west, east, center)
//		add(btn, BorderLayout.WEST); //위쪽에 추가
//		add(btn2, BorderLayout.CENTER);
		setSize(new Dimension(300,200));
		setLocation(100,50);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // x 버튼 누르면 종료되게
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
	////// 이벤트 처리하는 메소드는 따로
}
