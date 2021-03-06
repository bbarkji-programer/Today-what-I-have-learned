package ch00_practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentFrame extends JFrame {

	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate, btnStudentOut, btnExpel, btnExit, btnExpelOut;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private JComboBox<String> comMname;
	
	private Vector<String> mNames;
	
	private String driver, url;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	ArrayList<StudentDTO> students;
	ArrayList<StudentDTO2> students2;
	
	public StudentFrame(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		students = new ArrayList<StudentDTO>();
		students2 = new ArrayList<StudentDTO2>();
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:xe";

		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpel = new JButton("제적처리");
		btnExpelOut = new JButton("제적자출력");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10,50);
		scrollPane = new JScrollPane(txtPool);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	
	
	
	
}
