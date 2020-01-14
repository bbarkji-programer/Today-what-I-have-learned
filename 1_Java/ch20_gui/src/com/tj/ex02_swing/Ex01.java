package com.tj.ex02_swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex01 extends JFrame implements ActionListener { // swing 앞에는 J가 붙는당 // **이벤트 처리 STEP1.ActionLister 임플리먼트
	private Container contenPane;
	private JPanel jpanel;
	private JLabel jlbl;
	private JButton jbtn;
	
	public Ex01(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame에 있는 애. x 버튼 누르면 종료되도록.
//		contenPane = getContentPane(); // 컨테이너를 받아옴. 컨테이너 객체를 만드는 게 아니고 화면을 받아오는거라서 getContentPane();
		jpanel = (JPanel) getContentPane(); // 컨테이너를 받아와서 jpanel 변수에 형 변환 해도 됨~ <- 젤 먼저 해야함.
		jpanel.setLayout(new FlowLayout());
		jlbl = new JLabel("Happy Wednesday");
		jbtn = new JButton("EXIT");
		jlbl.setPreferredSize(new Dimension(250,200));
		jbtn.setPreferredSize(new Dimension(200,200));	
		jpanel.add(jlbl); // 컨테이너 얻어온 것을 jpanel로 받았으니까 페널에 add
		jpanel.add(jbtn);	
		pack(); // 화면은 최소한의 사이즈로. 사이즈 정할거면 setSize()
		
		setLocation(100,50);
		setVisible(true);
		
		jbtn.addActionListener(this); // **이벤트처리 STEP2. 이벤트 추가할 애(jbtn)한테 리스너 메소드 추가. this - 내 자신 안에 있는 퍼폼한다
		
	}
	public Ex01() {
		this("");
	}
	@Override
		public void actionPerformed(ActionEvent e) { // **이벤트 처리 STEP3. 어떤 이벤트 할건지 오버라이드
			if(e.getSource()==jbtn) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}	
	public static void main(String[] args) {
		new Ex01("My first Swing Ex.");
	}

}
