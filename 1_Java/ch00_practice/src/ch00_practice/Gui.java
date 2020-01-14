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
	// �ʿ��� ���� ����
	private Container contenPane; // �����̳�
	private JPanel pUp, pDown; // ����, �Ʒ���
	private JTextField txtPhone, txtName, txtPoint; // ����ȣ ���� ��, �̸� ���� ��, ����Ʈ ���� ��
	private JButton btnJoin, btnSearch, btnOut, btnExit; // ���� ��ư, ����ȸ ��ư, ��� ��ư, ���� ��ư
	private JTextArea txtArea; // ����, �˻� �� �ʿ������� ���̰� �� ��
	private JScrollPane jscP; // �ڵ����� ��ũ�� �����
	
	public Gui(String title) { // �޼ҵ� -- ���� �Լ����� Ŭ���� ��ȯ�ϸ�, �� �Ʒ� �۾��� �ض�.
		super(title);
		// �⺻ ������ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���� ��ư ������ ������ �ҰŸ� �⺻ ����		
		// ���� �� ����
		contenPane = getContentPane(); // �����̳� ����(get)
			contenPane.setLayout(new FlowLayout()); // �����̳ʿ� ������ ���� �Ŵϱ� ���̾ƿ� ����
		pUp = new JPanel(new GridLayout(3, 2)); // ���ڰ� �Ҷ�� �׸��� �гη� ���̾ƿ� ����
		pDown = new JPanel(new FlowLayout()); // ������� ���� �Ŵϱ� �÷ο� �гη� ���̾ƿ� ���� 
		txtPhone = new JTextField("��)010-1111-2222",15); // �⺻ ���� ����, ���� ���̸� 15��
		txtName = new JTextField("��)������", 15);
		txtPoint = new JTextField("���� �� ����Ʈ 1000�� �ڵ�����",15);
		txtPoint.setFocusable(false); // ����Ʈ�� �Է��� �� ����, ���ڸ� �� ���� �ְ�.
		btnJoin = new JButton();
		btnSearch = new JButton();
		btnOut = new JButton();
		btnExit = new JButton();
		txtArea = new JTextArea();
		jscP = new JScrollPane();
		
		pUp.add(new JLabel("����ȣ", (int)CENTER_ALIGNMENT));
		pUp.add(txtPhone);
		contenPane.add(pUp);
		
		
		setVisible(true);
		setBounds(300,300,400,450);
	}
	public static void main(String[] args) {
		new Gui("ȸ������");
	}
	

}
