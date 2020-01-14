package ch00_practice;

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
import javax.swing.JTextField;

public class Swing extends JFrame implements ActionListener {
	private Container contenPane;
	private JLabel lbl, lblBlnk;
	private JButton btn, btnExit;
	private JTextField txtField;
	private Vector<String> items;
	private JComboBox<String> combo;
	private JCheckBox chkbox;

	public Swing(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		
		lbl = new JLabel("Label");
		btn = new JButton("Button");
		txtField = new JTextField(20);
		items = new Vector<String>();
		items.add("A");
		items.add("B");
		items.add("C");
		combo = new JComboBox<String>(items);
		chkbox = new JCheckBox("Check Box");
		lblBlnk = new JLabel();
		btnExit = new JButton("EXIT");
		
		lbl.setPreferredSize(new Dimension(50,50));
		btn.setPreferredSize(new Dimension(100,50));
		txtField.setPreferredSize(new Dimension(300,50));
		combo.setPreferredSize(new Dimension(100,50));
		chkbox.setPreferredSize(new Dimension(100,50));
		lblBlnk.setPreferredSize(new Dimension(200,50));
		btnExit.setPreferredSize(new Dimension(100,50));
		
		contenPane.add(lbl);
		contenPane.add(btn);
		contenPane.add(txtField);
		contenPane.add(combo);
		contenPane.add(chkbox);
		contenPane.add(lblBlnk);
		contenPane.add(btnExit);
		
		setVisible(true);
		pack();
		setLocation(100,100);
		
		btn.addActionListener(this);
		btnExit.addActionListener(this);
		combo.addActionListener(this);
		chkbox.addActionListener(this);
				
	}
	public static void main(String[] args) {
		new Swing("Example");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			String str = txtField.getText().trim();
			if(!str.equals("")) {
				combo.addItem(str);
				lblBlnk.setText(str);
				txtField.setText("");
			}else {
				txtField.setText("");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==combo) {
			lblBlnk.setText(combo.getSelectedItem().toString());
		}else if(e.getSource()==chkbox) {
			if(chkbox.isSelected()) {
				lblBlnk.setText("Checked");
			}else {
				lblBlnk.setText("unChecked");
			}
		}	
	}
	
	

}
