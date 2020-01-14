package com.tj.ex02_swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerFrame extends JFrame implements ActionListener {

	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JScrollPane scrollP;
	private JTextArea jta;
	private ArrayList<Customer> customerList;
	
	public CustomerFrame(String title) {
		super(title);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(3,2));
		jpdown = new JPanel(new FlowLayout());
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000",15);
		txtPoint.setFocusable(false); // ����Ʈ�� �Է��� �� ���� ���� �� ���� �ְ�
		btnJoin = new JButton("����");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");
		jta = new JTextArea(15,30);
		scrollP = new JScrollPane(jta);
		customerList = new ArrayList<Customer>();

		jpup.add(new JLabel("����ȣ",(int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("��   ��",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����Ʈ",(int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);

		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);

		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollP);

		setVisible(true);
		setBounds(300,300,400,450);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin) {
		String phone, name;
		phone = txtPhone.getText().trim();
		name = txtName.getText().trim();
			if(!phone.equals("") && !name.equals("") && phone.indexOf('-')!=phone.lastIndexOf('-')) {
				Customer customer = new Customer(phone,name);
				customerList.add(customer);
				jta.setText(customer.toString()+"�Է¼���");	
				txtPhone.setText("");
				txtName.setText("");
			}else if(phone.equals("") || name.equals("")) {
				jta.setText("����ȣ �Ǵ� �̸��� �Է����� �ʾҽ��ϴ�.");
				return;
			}else if(phone.indexOf('-')==phone.lastIndexOf('-')) {
				jta.setText("��ȿ���� ���� ����ȣ�Դϴ�.");
				return;
			}							
		}else if(e.getSource()==btnSearch) {
			jta.setText("");
			String searchPhone = txtPhone.getText().trim();
			for(int idx=0 ; idx<customerList.size(); idx++) {
				String customerPhone = customerList.get(idx).getPhone();
				String postPhone = customerPhone.substring(customerPhone.lastIndexOf('-')+1);
				if(postPhone.equals(searchPhone)) {
					txtPhone.setText(customerList.get(idx).getPhone());
					txtName.setText(customerList.get(idx).getName());
					txtPoint.setText(String.valueOf(customerList.get(idx).getPoint())); // ����Ʈ�� int���̴ϱ� ����ȯ �ʿ�
					jta.append(customerList.get(idx).toString());
				}
			}
			if(jta.getText().equals("")){
				txtPhone.setText("���� ȸ���Դϴ�.");
				txtName.setText("");
				txtPoint.setText("");
				jta.setText("���� ȸ���Դϴ�.");
			}
		}else if(e.getSource()==btnOutput) {
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex02_swing/customer.txt");
				jta.setText("");
				for(Customer c : customerList) {
					System.out.println(c);
					jta.append(c.toString());
					writer.write(c.toString());				
				}
				System.out.println(customerList.size()+"�� �Է�");
				jta.append(customerList.size()+"�� �Է�");
				writer.write(customerList.size()+"�� �Է�");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if(writer!=null) writer.close();
				} catch (Exception e2) {
				}
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new CustomerFrame("ȸ������");
	}

}
