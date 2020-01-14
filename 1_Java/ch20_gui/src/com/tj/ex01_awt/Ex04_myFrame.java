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


public class Ex04_myFrame extends Frame implements ActionListener { // �̺�Ʈ �߰��Ϸ��� (1)implements����
	private Panel panel;
	private Button btnOK, btnEXIT;
	private TextField txtField;
	private List list; // awt�� import�ؾ�.
	
	public Ex04_myFrame() {
		//������Ʈ ��ü ����
		panel = new Panel(new FlowLayout());
		txtField = new TextField(20); // 20���� ���� width Ȯ��
		btnOK = new Button("OK");
		btnEXIT = new Button("EXIT");
		list = new List(5); // 5�� ���� ���� ���� Ȯ��(�� �̻� ������� ��ũ�ѻ���)
		//�гο� add ����
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOK);
		panel.add(btnEXIT);
		//�����ӿ� add ����
		add(panel,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		//���̰� ����
		setVisible(true);
		setSize(new Dimension(400,200));
		//��ġ ����
		setLocation(300,200);
		btnOK.addActionListener(this); // �̺�Ʈ�� �ʿ��� ��. this�� �ִ� actionPerformed ����
		btnEXIT.addActionListener(this);
		//x ������ ������ ����
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
	// �̺�Ʈ �߰� (implement -> addActionListener -> actionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnEXIT) {
				setVisible(false);
				dispose();
				System.exit(0);
			}else if(e.getSource()==btnOK) {
				//txtField.getText()�� list�� add
				list.add(txtField.getText());
				//txtField text�� "" <- �Է� �Ŀ��� �Է�â�� ����
				txtField.setText("");
			}
			
		}
	public static void main(String[] args) {
		new Ex04_myFrame("���� ������Ʈ ����");
	}
}
