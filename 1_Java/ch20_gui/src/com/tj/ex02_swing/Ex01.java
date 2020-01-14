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

public class Ex01 extends JFrame implements ActionListener { // swing �տ��� J�� �ٴ´� // **�̺�Ʈ ó�� STEP1.ActionLister ���ø���Ʈ
	private Container contenPane;
	private JPanel jpanel;
	private JLabel jlbl;
	private JButton jbtn;
	
	public Ex01(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame�� �ִ� ��. x ��ư ������ ����ǵ���.
//		contenPane = getContentPane(); // �����̳ʸ� �޾ƿ�. �����̳� ��ü�� ����� �� �ƴϰ� ȭ���� �޾ƿ��°Ŷ� getContentPane();
		jpanel = (JPanel) getContentPane(); // �����̳ʸ� �޾ƿͼ� jpanel ������ �� ��ȯ �ص� ��~ <- �� ���� �ؾ���.
		jpanel.setLayout(new FlowLayout());
		jlbl = new JLabel("Happy Wednesday");
		jbtn = new JButton("EXIT");
		jlbl.setPreferredSize(new Dimension(250,200));
		jbtn.setPreferredSize(new Dimension(200,200));	
		jpanel.add(jlbl); // �����̳� ���� ���� jpanel�� �޾����ϱ� ��ο� add
		jpanel.add(jbtn);	
		pack(); // ȭ���� �ּ����� �������. ������ ���ҰŸ� setSize()
		
		setLocation(100,50);
		setVisible(true);
		
		jbtn.addActionListener(this); // **�̺�Ʈó�� STEP2. �̺�Ʈ �߰��� ��(jbtn)���� ������ �޼ҵ� �߰�. this - �� �ڽ� �ȿ� �ִ� �����Ѵ�
		
	}
	public Ex01() {
		this("");
	}
	@Override
		public void actionPerformed(ActionEvent e) { // **�̺�Ʈ ó�� STEP3. � �̺�Ʈ �Ұ��� �������̵�
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
