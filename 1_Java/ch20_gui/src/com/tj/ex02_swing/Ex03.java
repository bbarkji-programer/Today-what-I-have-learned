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
	// 변수선언
	private Container contenPane;
	private JPanel pUp, pDown;
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon i01, i02; // 이미지 아이콘도 변수이름 선언
	private JButton btnIn, btnOut;
	private JTextArea txtArea;
	private JScrollPane scrollP; // textArea는 스크롤바를 따로 선언해줘야 알아서 생김. (*List는 자동으로 생김)
	private HashMap<String, Person> person; // hashmap은 key(K)로 access <키값, 밸류값타입> <어떤형을,어디에서> 변수
	
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
		btnIn = new JButton("입력",i01); // 이미지를 추가한 버튼
		i02 = new ImageIcon("icon/write.gif");
		btnOut = new JButton("출력",i02);
		txtArea = new JTextArea(5,30);
		scrollP = new JScrollPane(txtArea); // 스크롤판에 텍스트에리어를 추가하는 개념임...
		person = new HashMap<String, Person>();
				
		pUp.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		pUp.add(txtName);
		pUp.add(new JLabel("전화", (int)CENTER_ALIGNMENT));
		pUp.add(txtTel);
		pUp.add(new JLabel("나이", (int)CENTER_ALIGNMENT));
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
		new Ex03("GUI 예제");
	}
	@Override
	public void actionPerformed(ActionEvent e) { // 액션 추가할 게 2개면 여기 if 가 2개여야 정상~
		if(e.getSource()==btnIn) {
			// txtName, txtTel, txtAge를 person에 추가~
			String name, tel;
			int age;
			name = txtName.getText().trim(); // 텍스트 필드에 입력된 Text를 겟해서 트리밍~
			tel = txtTel.getText().trim();
			age=0;
			try {
				age = Integer.parseInt(txtAge.getText().trim()); // 입력되는 값은 스트링이니까 형 변환~				
			}catch (NumberFormatException error) {
				txtArea.setText("유효하지 않은 나이 타입(공백 등)입니다."); // textArea에 텍스트를 뿌려라~
				return;
			}// 여기 넘어왔다면, 세 값이 모두 입력된 것.
			if(name.equals("") || tel.equals("")) {
				txtArea.setText("이름 또는 전화번호를 입력하지 않았습니다.");
				return;
			}
			if(age>150 || age<0) { // 나이값 유효성 검증
				txtArea.setText("유효하지 않은 나이 값입니다.");
				return; // 다시 처음으로
			}// 여기 넘어왔다면, 유효한 나이값을 입력한 것.
			//person 해시맵에 같은 폰 번호가 있는지 검사
			int idx = 0; // while 문을 돌릴 때마다 하나씩 증가예정. <- while 문을 제대로 돌려서 tel을 찾았는지 확인용.
			Iterator<String> iterator = person.keySet().iterator();
			while(iterator.hasNext()) {
				String tempTel = iterator.next();
				if(tempTel.equals(tel)) { // 내가 입력한 전화번호랑 iterator.next() 값이 같으면
					break;
				}
				idx++; // 파일문을 한번 제대로 실행할 때마다 idx++. idx++가 해시맵 사이즈랑 똑같아지면, 끝가지 잘 돈것이지.
			}
			if(idx < person.size()) { // tempTel과 tel이 같아서 break 되서 나온경우. (idx가 해시맵 사이즈보다 작으니까)
				txtArea.setText("이미 가입한 전화번호입니다.");
				return;				
			}// 사이즈가 작지 않다면,
			Person p = new Person(name,tel,age);
			person.put(tel, p); // 해시맵에 추가(put) - 해시맵이름.put(hash맵 고유 key값이 tel, 그 키 값 마다 넣을 정보가 뒤에)
			txtArea.setText(p.toString()+"입력성공");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText(""); // 입력 후에는 빈칸으로 셋팅~
			
		}else if(e.getSource()==btnOut) {
			// person 해시맵 내용을 콘솔창에 출력하고, 파일로도 출력하고~
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex02_swing/person.txt");
				Iterator<String> iterator = person.keySet().iterator();	
				txtArea.setText("");
				while(iterator.hasNext()) {
					String tempTel = iterator.next();
					Person p = person.get(tempTel);
					System.out.println(p); // 콘솔출력
					txtArea.append(p.toString()); //txtArea에 출력
					writer.write(p.toString()); // 파일 출력
				}
				System.out.println(person.size()+"명 입력");
				txtArea.append(person.size()+"명 입력");
				writer.append(person.size()+"명 입력");
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
