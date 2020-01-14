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
	//(1)필요 변수 선언
	private Container contenPane;
	private JLabel jlbl, jlblBlnk;
	private JButton jbtn, jbtnExit;
	private JTextField jtxtField; // TextField는 한 줄만 입력 가능. \r\n 이 안먹힌다. -> 여러 줄 쓰고 싶으면 TextArea
	private JComboBox<String> jcombo; // A,B 이런거 넣을 거라서
	private JCheckBox jchk; 
	private Vector<String> items; // 데이터 박스에 따라 항목이 달라지는 경우가 대부분이라 보통 콤보박스 항목은 vector 씀.
//	private String[] item = {"A","B","C"}; // 콤보박스에 들어갈 항목을 순서대로, 뭐가 올지 알 때는 vector 말고 String 써도 됨. 근데 거의...
	
	public Ex02() {
		//(2)기본 기능 추가
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 기본. x 버튼 누르면 종료
		//(3)컨텐이너 얻어오기
		contenPane = getContentPane(); // 컨테이너 얻어오기
		contenPane.setLayout(new FlowLayout());
		//(4)컨테이너 안에 넣을 변수 열기
		jlbl = new JLabel("Label");
	    jbtn = new JButton("Button");
	    jtxtField = new JTextField(20);
	    items = new Vector<String>(); // 콤보 박스에 들어갈 항목들을 Vector에
	    items.add("A");
	    items.add("B");
	    items.add("C");
	    jcombo = new JComboBox<String>(items); // 콤보박스 생성. vector를 이용해서 항목 추가 후 생성~
	    jchk = new JCheckBox("Check Box");
		jlblBlnk = new JLabel(); // 암것도 안 넣으면 빈 라벨
		jbtnExit = new JButton("EXIT");
		//(5)컨테이너 안에 오는 것들 사이즈 조정하기
		jlbl.setPreferredSize(new Dimension(50,50));
		jbtn.setPreferredSize(new Dimension(100,50));
		jtxtField.setPreferredSize(new Dimension(300,50));
		jcombo.setPreferredSize(new Dimension(100,50));
		jchk.setPreferredSize(new Dimension(100,50));
		jlblBlnk.setPreferredSize(new Dimension(200,50));
		jbtnExit.setPreferredSize(new Dimension(100,50));
		//(6)컨테이너에 추가하기
		contenPane.add(jlbl);
		contenPane.add(jbtn);
		contenPane.add(jtxtField);
		contenPane.add(jcombo);
		contenPane.add(jchk);
		contenPane.add(jlblBlnk);
		contenPane.add(jbtnExit);
		//(7)보이게하고, 컨테이너 사이즈정하기, 위치 정하기
		setVisible(true);
		pack();
		setLocation(100,50);
		//(8)액션 추가하기 - 액션 추가할 것들
		jbtn.addActionListener(this);
		jcombo.addActionListener(this);
		jchk.addActionListener(this);
		jbtnExit.addActionListener(this);		
	}
	//(8)액션 추가하기 - 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			// 텍스트 필드의 값을 콤보박스에 추가하고, 빈칸 화면에도 나타나게
			String str = jtxtField.getText().trim(); // 이게 계속 나오니까 변수로 선언.
			if(!str.equals("")) { // 입력한 값이 공백이 아닌 경우(없지 않은 경우)에만 {}를 한다.(작동한다.)
				jcombo.addItem(str); // 입력한 값을 트림해서 콤보박스에 추가한다.
				jlblBlnk.setText(str); // 블랭크에 텍스트를 set
				jtxtField.setText("");// 다 입력된 후에는 텍스트 필드를 다시 빈칸으로 set			
 			}else {
 				jtxtField.setText(""); // 스페이스키만 누르면 텍스트필드를 빈칸으로 set
 			}
		}else if(e.getSource()==jcombo){
			//jcombo 선택된 항목을 블랭크에 나타나게
			jlblBlnk.setText(jcombo.getSelectedItem().toString()); // 블랭크에 셋팅한다(콤보박스에서 선택된것을.근데 setText에는 스트링을 넣어야 하니까 toString)
		}else if(e.getSource()==jchk) {
			// 체크하면 블랭크에 체크했다고, 안하면 안했다고 나타나게
			if(jchk.isSelected()) { // true 면 체크됨
				jlblBlnk.setText("Checked"); // 블랭크에. 글자를 셋팅한다. ("여기쓴 값으로")
			}else { // 체크가 풀리면,
				jlblBlnk.setText("unChecked");
			}
		}else if(e.getSource()==jbtnExit) {
			// 종료할거냐고 묻기
			int answer = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?"); // 다이어로그를 뜨게함
			if(answer == 0) { // 종료를 선택하면,
				// 종료
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
