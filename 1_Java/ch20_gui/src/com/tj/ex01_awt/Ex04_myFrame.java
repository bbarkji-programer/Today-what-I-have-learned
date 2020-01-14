package com.tj.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ex04_myFrame extends Frame implements ActionListener { // 이벤트 추가하려면 (1)implements부터
	private Panel panel;
	private Button btnOK, btnEXIT;
	private TextField txtField;
	private List list; // awt로 import해야.
	
	public Ex04_myFrame() {
		//컴포넌트 객체 생성
		panel = new Panel(new FlowLayout());
		txtField = new TextField(20); // 20글자 들어가는 width 확보
		btnOK = new Button("OK");
		btnEXIT = new Button("EXIT");
		list = new List(5); // 5줄 정도 들어가는 공간 확보(그 이상 길어지면 스크롤생김)
		//패널에 add 하자
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOK);
		panel.add(btnEXIT);
		//프레임에 add 하자
		add(panel,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		//보이게 하자
		setVisible(true);
		setSize(new Dimension(400,200));
		//위치 잡자
		setLocation(300,200);
		btnOK.addActionListener(this); // 이벤트가 필요한 곳. this에 있는 actionPerformed 실행
		btnEXIT.addActionListener(this);
		//x 누르면 꺼지게 하자
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		
	}
	public Ex04_myFrame(String title) {
		this();
		setTitle(title);		
	}
	// 이벤트 추가 (implement -> addActionListener -> actionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnEXIT) {
				setVisible(false);
				dispose();
				System.exit(0);
			}else if(e.getSource()==btnOK) {
				//txtField.getText()를 list에 add
				list.add(txtField.getText());
				//txtField text를 "" <- 입력 후에는 입력창을 비운당
				txtField.setText("");
			}
			
		}
	public static void main(String[] args) {
		new Ex04_myFrame("여러 컴포넌트 예제");
	}
}
