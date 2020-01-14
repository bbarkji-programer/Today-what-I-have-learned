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
		txtPoint.setFocusable(false); // 포인트는 입력할 수 없고 수를 볼 수만 있게
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		jta = new JTextArea(15,30);
		scrollP = new JScrollPane(jta);
		customerList = new ArrayList<Customer>();

		jpup.add(new JLabel("폰번호",(int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이   름",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트",(int)CENTER_ALIGNMENT));
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
				jta.setText(customer.toString()+"입력성공");	
				txtPhone.setText("");
				txtName.setText("");
			}else if(phone.equals("") || name.equals("")) {
				jta.setText("폰번호 또는 이름을 입력하지 않았습니다.");
				return;
			}else if(phone.indexOf('-')==phone.lastIndexOf('-')) {
				jta.setText("유효하지 않은 폰번호입니다.");
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
					txtPoint.setText(String.valueOf(customerList.get(idx).getPoint())); // 포인트는 int형이니까 형변환 필요
					jta.append(customerList.get(idx).toString());
				}
			}
			if(jta.getText().equals("")){
				txtPhone.setText("없는 회원입니다.");
				txtName.setText("");
				txtPoint.setText("");
				jta.setText("없는 회원입니다.");
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
				System.out.println(customerList.size()+"명 입력");
				jta.append(customerList.size()+"명 입력");
				writer.write(customerList.size()+"명 입력");
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
		new CustomerFrame("회원관리");
	}

}
