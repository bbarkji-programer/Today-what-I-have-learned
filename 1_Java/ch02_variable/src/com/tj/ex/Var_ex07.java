package com.tj.ex;

public class Var_ex07 {
	public static void main(String[] args) {
		byte b = 10;
		double d = 10; //���� ������ �� ������ �� ��ȯ�� �ʿ���� d=10.0 <- ������ ����ȯ
		double d2 = 10.91; 
		int i = (int)d2; //4byte < 8byte �̱� ������ (int)�ʿ� <- ����� ����ȯ(*������ �ս��� ���� �� �ִ�.)
		//i = (10+20+30)/7; //�������� �����ϸ� �����θ� ����. �Ҽ� �ϰ� ������ �ڿ� .0 �ٿ��� �Ѵ�.
	}
}
