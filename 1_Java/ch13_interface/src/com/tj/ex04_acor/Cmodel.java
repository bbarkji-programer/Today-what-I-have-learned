package com.tj.ex04_acor;
//DMB�ۼ��� �Ұ�, LTE, TV������ ��ž��
public class Cmodel implements IAcor {

	private String model = "C��";
	
	@Override
	public void dmbReceive() {
		System.out.println(model+"�� DMB�ۼ��� ����");
	}

	@Override
	public void lte() {
		System.out.println(model+"�� LTE��");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"�� TV������ ��ž��");
	}

}
