package com.tj.ex04_acor;
// DMB�ۼ��� �Ұ�, 3G, TV������ ž��
public class Amodel implements IAcor {

	private String model = "A��";
			
	@Override
	public void dmbReceive() {
		System.out.println(model+"�� DMB�ۼ��� �Ұ�");
	}

	@Override
	public void lte() {
		System.out.println(model+"�� 3G ��");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"�� TV������ ��ž��");
	}

}
