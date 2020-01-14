package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	
	private String add; // �ּ�
	private int sum; // �����ݾ�
	private int point; // ����Ʈ(������ �� ���� 5% ����)
	private String date; // �����
	private boolean vip; // true=vip��, false=�Ϲݰ�
	
	// Customer c = new Customer("Ȩ","9999-9999","����","0108");
	public Customer(String name, String tel, String add, String date) { 	
		// super�� ������ ȣ���� �ݵ�� ù ��° ����!!
		super(name, tel); // �Ű� ���� ���� ������ ����, �ִ� ������ ȣ��
		this.add = add;
		this.date = date;
		sum = 0 ; // ���ο� ���� �����ݾ� 0��
		point = 1000; // ȸ������ �� 1,000�� ����Ʈ �ڵ�����
		vip = false; // ���ο� ���� �Ϲݰ����� �ڵ��з�
		System.out.println(name+"�� �����մϴ�. ����ſ�. ����Ʈ 1000���� ������ ���޵Ǿ����.");
	}
	public void buy(int price) {
		// c.buy(10000);
		sum += price;
		int tempPoint = (int)(price*Constant.RATE);
		point += tempPoint;
		System.out.println(getName()+"�� �����մϴ�. �ݹ� ����Ʈ: "+tempPoint
				           +"��, �� ����Ʈ: "+point+"�� �Դϴ�.");
		if(sum>1000000 && vip==false) {
			vip = true; // ���� �ݾ��� 1�鸸 �� �ʰ� �� vip ������
		}//if			
	}//buy
	// [�̸�]ȫ�浿 [��ȭ]0000-0000 [�ּ�]�������� [����Ʈ] 500
	@Override
	public String infoString() {
		return super.infoString()+" [�ּ�]"+add+" [����Ʈ]"+point;
	}

}
