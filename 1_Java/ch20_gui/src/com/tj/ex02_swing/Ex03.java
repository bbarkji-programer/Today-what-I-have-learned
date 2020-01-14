package com.tj.ex02_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03 extends JFrame implements ActionListener {
	// ��������
	private Container contenPane;
	private JPanel pUp, pDown;
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon i01, i02; // �̹��� �����ܵ� �����̸� ����
	private JButton btnIn, btnOut;
	private JTextArea txtArea;
	private JScrollPane scrollP; // textArea�� ��ũ�ѹٸ� ���� ��������� �˾Ƽ� ����. (*List�� �ڵ����� ����)
	private HashMap<String, Person> person; // hashmap�� key(K)�� access <Ű��, �����Ÿ��> <�����,��𿡼�> ����
	
	public Ex03(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		
		pUp = new JPanel(new GridLayout(3, 2));
		pDown = new JPanel(new FlowLayout());
		txtName = new JTextField(15);
		txtTel = new JTextField();
		txtAge = new JTextField();
		i01 = new ImageIcon("icon/bell.gif");		
		btnIn = new JButton("�Է�",i01); // �̹����� �߰��� ��ư
		i02 = new ImageIcon("icon/write.gif");
		btnOut = new JButton("���",i02);
		txtArea = new JTextArea(5,30);
		scrollP = new JScrollPane(txtArea); // ��ũ���ǿ� �ؽ�Ʈ����� �߰��ϴ� ������...
		person = new HashMap<String, Person>();
				
		pUp.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		pUp.add(txtName);
		pUp.add(new JLabel("��ȭ", (int)CENTER_ALIGNMENT));
		pUp.add(txtTel);
		pUp.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		pUp.add(txtAge);
		pDown.add(btnIn);
		pDown.add(btnOut);
		pDown.add(scrollP);
		
		btnIn.setPreferredSize(new Dimension(140,50));
		btnOut.setPreferredSize(new Dimension(140,50));
			
		contenPane.add(pUp);
		contenPane.add(pDown);
		contenPane.add(scrollP);
		
		setVisible(true);
//		setSize(400,320);
//		setLocation(100,100);
		setBounds(100,100,430,290);
		
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);

	}
	public Ex03() {
		this("");
	}
	public static void main(String[] args) {
		new Ex03("GUI ����");
	}
	@Override
	public void actionPerformed(ActionEvent e) { // �׼� �߰��� �� 2���� ���� if �� 2������ ����~
		if(e.getSource()==btnIn) {
			// txtName, txtTel, txtAge�� person�� �߰�~
			String name, tel;
			int age;
			name = txtName.getText().trim(); // �ؽ�Ʈ �ʵ忡 �Էµ� Text�� ���ؼ� Ʈ����~
			tel = txtTel.getText().trim();
			age=0;
			try {
				age = Integer.parseInt(txtAge.getText().trim()); // �ԷµǴ� ���� ��Ʈ���̴ϱ� �� ��ȯ~				
			}catch (NumberFormatException error) {
				txtArea.setText("��ȿ���� ���� ���� Ÿ��(���� ��)�Դϴ�."); // textArea�� �ؽ�Ʈ�� �ѷ���~
				return;
			}// ���� �Ѿ�Դٸ�, �� ���� ��� �Էµ� ��.
			if(name.equals("") || tel.equals("")) {
				txtArea.setText("�̸� �Ǵ� ��ȭ��ȣ�� �Է����� �ʾҽ��ϴ�.");
				return;
			}
			if(age>150 || age<0) { // ���̰� ��ȿ�� ����
				txtArea.setText("��ȿ���� ���� ���� ���Դϴ�.");
				return; // �ٽ� ó������
			}// ���� �Ѿ�Դٸ�, ��ȿ�� ���̰��� �Է��� ��.
			//person �ؽøʿ� ���� �� ��ȣ�� �ִ��� �˻�
			int idx = 0; // while ���� ���� ������ �ϳ��� ��������. <- while ���� ����� ������ tel�� ã�Ҵ��� Ȯ�ο�.
			Iterator<String> iterator = person.keySet().iterator();
			while(iterator.hasNext()) {
				String tempTel = iterator.next();
				if(tempTel.equals(tel)) { // ���� �Է��� ��ȭ��ȣ�� iterator.next() ���� ������
					break;
				}
				idx++; // ���Ϲ��� �ѹ� ����� ������ ������ idx++. idx++�� �ؽø� ������� �Ȱ�������, ������ �� ��������.
			}
			if(idx < person.size()) { // tempTel�� tel�� ���Ƽ� break �Ǽ� ���°��. (idx�� �ؽø� ������� �����ϱ�)
				txtArea.setText("�̹� ������ ��ȭ��ȣ�Դϴ�.");
				return;				
			}// ����� ���� �ʴٸ�,
			Person p = new Person(name,tel,age);
			person.put(tel, p); // �ؽøʿ� �߰�(put) - �ؽø��̸�.put(hash�� ���� key���� tel, �� Ű �� ���� ���� ������ �ڿ�)
			txtArea.setText(p.toString()+"�Է¼���");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText(""); // �Է� �Ŀ��� ��ĭ���� ����~
			
		}else if(e.getSource()==btnOut) {
			// person �ؽø� ������ �ܼ�â�� ����ϰ�, ���Ϸε� ����ϰ�~
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex02_swing/person.txt");
				Iterator<String> iterator = person.keySet().iterator();	
				txtArea.setText("");
				while(iterator.hasNext()) {
					String tempTel = iterator.next();
					Person p = person.get(tempTel);
					System.out.println(p); // �ܼ����
					txtArea.append(p.toString()); //txtArea�� ���
					writer.write(p.toString()); // ���� ���
				}
				System.out.println(person.size()+"�� �Է�");
				txtArea.append(person.size()+"�� �Է�");
				writer.append(person.size()+"�� �Է�");
			} catch (IOException e2) {
				// TODO: handle exception
			} finally {
				try {
					if(writer!=null) writer.close();
				} catch (Exception e3) {
				}
			}
	
				


		}
	}
	

}
