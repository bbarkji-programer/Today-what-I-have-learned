package ch00_practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame {
	// 필요한 변수 선언
	private Container contenPane; // 컨테이너
	private JPanel pUp, pDown; // 윗판, 아랫판
	private JTextField txtPhone, txtName, txtPoint; // 폰번호 적을 곳, 이름 적을 곳, 포인트 보일 것
	private JButton btnJoin, btnSearch, btnOut, btnExit; // 가입 버튼, 폰조회 버튼, 출력 버튼, 종료 버튼
	private JTextArea txtArea; // 가입, 검색 등 필요정보를 보이게 할 곳
	private JScrollPane jscP; // 자동으로 스크롤 생기게
	
	public Gui(String title) { // 메소드 -- 메인 함수에서 클래스 소환하면, 이 아래 작업을 해라.
		super(title);
		// 기본 설정값 셋팅
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫힘 버튼 누르면 닫히게 할거면 기본 셋팅		
		// 변수 값 셋팅
		contenPane = getContentPane(); // 컨테이너 열기(get)
			contenPane.setLayout(new FlowLayout()); // 컨테이너에 순차로 담을 거니까 레이아웃 셋팅
		pUp = new JPanel(new GridLayout(3, 2)); // 예쁘게 할라고 그리드 패널로 레이아웃 셋팅
		pDown = new JPanel(new FlowLayout()); // 순서대로 담을 거니까 플로우 패널로 레이아웃 셋팅 
		txtPhone = new JTextField("예)010-1111-2222",15); // 기본 문자 셋팅, 가로 길이를 15로
		txtName = new JTextField("예)박지영", 15);
		txtPoint = new JTextField("가입 시 포인트 1000점 자동지급",15);
		txtPoint.setFocusable(false); // 포인트는 입력할 수 없고, 숫자를 볼 수만 있게.
		btnJoin = new JButton();
		btnSearch = new JButton();
		btnOut = new JButton();
		btnExit = new JButton();
		txtArea = new JTextArea();
		jscP = new JScrollPane();
		
		pUp.add(new JLabel("폰번호", (int)CENTER_ALIGNMENT));
		pUp.add(txtPhone);
		contenPane.add(pUp);
		
		
		setVisible(true);
		setBounds(300,300,400,450);
	}
	public static void main(String[] args) {
		new Gui("회원관리");
	}
	

}
