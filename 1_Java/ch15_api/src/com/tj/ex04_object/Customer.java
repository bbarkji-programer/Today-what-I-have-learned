package com.tj.ex04_object;

public class Customer {

	private String phone; // ��ȭ��ȣ
	private String name; // ����
	private int point; // ����Ʈ
	private int sum; // ���� ���űݾ�
	private String birth; // ���� 01-08
	private boolean vip; // false:�Ϲݰ�, true:vip��
	
	// �����Լ����� Customer c = new Customer("010-0000-0000","ȫ�浿","01-08") �̷���
	public Customer(String phone, String name, String birth) {
		super();
		this.phone = phone;
		this.name = name;
		this.birth = birth;
		point = 1000;
		sum=0;
		vip=false;
		System.out.println(name+"ȸ���� ���� �����մϴ�. ���� ����Ʈ 1000�� �帳�ϴ�.");
	}
	//sysout(c) -> ȫ�浿(010-0000-0000) ���� ����Ʈ: 000�� �����ݾ�: 0��
	@Override
	public String toString() {
		return name+"("+phone+") ���� ����Ʈ: "+point+"�� �����ݾ�: "+sum+"��";
	}
	
}
