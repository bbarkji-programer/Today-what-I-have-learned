package com.tj.condition;

public class If_ex02 {

	public static void main(String[] args) {
	
		int seoulLunchPrice = 4900; //���� �̸��� ģ���ϰ� �� ���� �� �� �ְ�(���� �߼�)
		
		if(seoulLunchPrice >7000) {
			System.out.println("���� �䰪�� ��γ׿�.");
		}else if(seoulLunchPrice >6000) {
			System.out.println("���� �䰪�� ���ݸ� �� ����������");
		}else if(seoulLunchPrice >=4000) {
			System.out.println("���� �䰪�� ���׿�.");
		}else {
			System.out.println("�� ���� ������ �Ĵ��� ������ ��������?");
		}
	}

}
