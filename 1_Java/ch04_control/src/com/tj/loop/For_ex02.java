package com.tj.loop;
// ��� : 1~20���� �������� ���
// ��� : 1+2+3+4+...+18+19+20=210
public class For_ex02 {
	public static void main(String[] args) {
		int tot = 0; // ������ ���� ('����'�̴ϱ� �ʿ�)
		for(int i=1 ; i<=20 ; i++) {
			if(i==20) {
				System.out.print(i);
			}else {
				System.out.print(i+"+");
			}
			tot = tot+i;
			}
		System.out.println("="+tot);
	}
}
