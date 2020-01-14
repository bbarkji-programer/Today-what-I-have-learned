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

public class Ex02_myFrame extends Frame implements ActionListener { // ActionListener 로 이벤트처리
	// 컴포넌트 변수 선언
	private Label lbl01;
	private Button btnExit;
	// 생성자 - 화면구성
	public Ex02_myFrame(String name) {
		super(name);
//		setLayout(new BorderLayout()); // 가장 기본. 아무것도 안쓰면 이것.
//		setLayout(new GridLayout(1,2)); // 1행 2열 짜리 그리드 레이아웃
		setLayout(new FlowLayout()); // 왼쪽부터 차곡차곡~
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
		btnExit.addActionListener(this); // 이벤트 처리할 거요. 이벤트가 벌어질때마다 내 자신(this)안에 있는 actionPerformed 호출
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
	// 이벤트처리 - 클릭 시 뭐해라
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