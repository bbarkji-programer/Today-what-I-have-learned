package com.tj.op;

public class Op_ex05 {
	public static void main(String[] args) {
		System.out.println("* * *���׿�����* * *");
		// ���׿����� // ���� ? ������ ���� �� ���� �� : ������ ������ �� ���� ��
		
		int h=100;
		String result = (h%2==0) ? "¦����" : "Ȧ����";
		System.out.println(result);
		
		// �����ϰ� �� �ٷ� ���ٸ�,
		System.out.println((h%2==0)? "¦����":"Ȧ����");
	}		
}
