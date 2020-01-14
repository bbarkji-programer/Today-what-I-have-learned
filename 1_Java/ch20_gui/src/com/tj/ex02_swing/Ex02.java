package com.tj.ex02_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {
	//(1)�ʿ� ���� ����
	private Container contenPane;
	private JLabel jlbl, jlblBlnk;
	private JButton jbtn, jbtnExit;
	private JTextField jtxtField; // TextField�� �� �ٸ� �Է� ����. \r\n �� �ȸ�����. -> ���� �� ���� ������ TextArea
	private JComboBox<String> jcombo; // A,B �̷��� ���� �Ŷ�
	private JCheckBox jchk; 
	private Vector<String> items; // ������ �ڽ��� ���� �׸��� �޶����� ��찡 ��κ��̶� ���� �޺��ڽ� �׸��� vector ��.
//	private String[] item = {"A","B","C"}; // �޺��ڽ��� �� �׸��� �������, ���� ���� �� ���� vector ���� String �ᵵ ��. �ٵ� ����...
	
	public Ex02() {
		//(2)�⺻ ��� �߰�
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �⺻. x ��ư ������ ����
		//(3)�����̳� ������
		contenPane = getContentPane(); // �����̳� ������
		contenPane.setLayout(new FlowLayout());
		//(4)�����̳� �ȿ� ���� ���� ����
		jlbl = new JLabel("Label");
	    jbtn = new JButton("Button");
	    jtxtField = new JTextField(20);
	    items = new Vector<String>(); // �޺� �ڽ��� �� �׸���� Vector��
	    items.add("A");
	    items.add("B");
	    items.add("C");
	    jcombo = new JComboBox<String>(items); // �޺��ڽ� ����. vector�� �̿��ؼ� �׸� �߰� �� ����~
	    jchk = new JCheckBox("Check Box");
		jlblBlnk = new JLabel(); // �ϰ͵� �� ������ �� ��
		jbtnExit = new JButton("EXIT");
		//(5)�����̳� �ȿ� ���� �͵� ������ �����ϱ�
		jlbl.setPreferredSize(new Dimension(50,50));
		jbtn.setPreferredSize(new Dimension(100,50));
		jtxtField.setPreferredSize(new Dimension(300,50));
		jcombo.setPreferredSize(new Dimension(100,50));
		jchk.setPreferredSize(new Dimension(100,50));
		jlblBlnk.setPreferredSize(new Dimension(200,50));
		jbtnExit.setPreferredSize(new Dimension(100,50));
		//(6)�����̳ʿ� �߰��ϱ�
		contenPane.add(jlbl);
		contenPane.add(jbtn);
		contenPane.add(jtxtField);
		contenPane.add(jcombo);
		contenPane.add(jchk);
		contenPane.add(jlblBlnk);
		contenPane.add(jbtnExit);
		//(7)���̰��ϰ�, �����̳� ���������ϱ�, ��ġ ���ϱ�
		setVisible(true);
		pack();
		setLocation(100,50);
		//(8)�׼� �߰��ϱ� - �׼� �߰��� �͵�
		jbtn.addActionListener(this);
		jcombo.addActionListener(this);
		jchk.addActionListener(this);
		jbtnExit.addActionListener(this);		
	}
	//(8)�׼� �߰��ϱ� - �׼�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			// �ؽ�Ʈ �ʵ��� ���� �޺��ڽ��� �߰��ϰ�, ��ĭ ȭ�鿡�� ��Ÿ����
			String str = jtxtField.getText().trim(); // �̰� ��� �����ϱ� ������ ����.
			if(!str.equals("")) { // �Է��� ���� ������ �ƴ� ���(���� ���� ���)���� {}�� �Ѵ�.(�۵��Ѵ�.)
				jcombo.addItem(str); // �Է��� ���� Ʈ���ؼ� �޺��ڽ��� �߰��Ѵ�.
				jlblBlnk.setText(str); // ��ũ�� �ؽ�Ʈ�� set
				jtxtField.setText("");// �� �Էµ� �Ŀ��� �ؽ�Ʈ �ʵ带 �ٽ� ��ĭ���� set			
 			}else {
 				jtxtField.setText(""); // �����̽�Ű�� ������ �ؽ�Ʈ�ʵ带 ��ĭ���� set
 			}
		}else if(e.getSource()==jcombo){
			//jcombo ���õ� �׸��� ��ũ�� ��Ÿ����
			jlblBlnk.setText(jcombo.getSelectedItem().toString()); // ��ũ�� �����Ѵ�(�޺��ڽ����� ���õȰ���.�ٵ� setText���� ��Ʈ���� �־�� �ϴϱ� toString)
		}else if(e.getSource()==jchk) {
			// üũ�ϸ� ��ũ�� üũ�ߴٰ�, ���ϸ� ���ߴٰ� ��Ÿ����
			if(jchk.isSelected()) { // true �� üũ��
				jlblBlnk.setText("Checked"); // ��ũ��. ���ڸ� �����Ѵ�. ("���⾴ ������")
			}else { // üũ�� Ǯ����,
				jlblBlnk.setText("unChecked");
			}
		}else if(e.getSource()==jbtnExit) {
			// �����Ұųİ� ����
			int answer = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?"); // ���̾�α׸� �߰���
			if(answer == 0) { // ���Ḧ �����ϸ�,
				// ����
				setVisible(false);
				dispose();
				System.exit(0);				
			}
		}		
	}
	public static void main(String[] args) {
		new Ex02();
	}
}
