package com.tj.ex10_customer;

public class Staff extends Person {
	
	private String hiredate; // 2020-05-01 <- ���ֺ��ʹ� date ������ 
	private String department; // �μ�
	
	// Staff s = new Staff("ȫ�浿", "9999-9999", "2020-05-01", "�����");
	public Staff(String name, String tel, String hiredate, String department) {
		// super�� �ݵ�� ù ��° ����!!!
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println(name+"�� �Ի縦 �����մϴ�:D");
	}
	//sysout(s.infoString()) -> [�̸�]ȫ�浿 [��ȭ]9999-9999 [�μ�]�����
	@Override
	public String infoString() { 
		return super.infoString()+" [�μ�]"+department;
	}
	
}


