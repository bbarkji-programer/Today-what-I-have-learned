package com.tj.ex;

//������ ����6) �Ž����� 2680�� 500, 100, 50, 10¥�� �������� �ٶ� ��� �־�� �ϳ�?
//		        ��Ʈ :  coinUnit[i] + ���� ; �� + money/coinUnit[i]        
//			 money = money%coinUnit[i];

public class Array_ex11 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coinUnit = { 500, 100, 50, 10 };
		// forȮ�屸��
		for (int coin : coinUnit) {
			System.out.print(coin + "�� ¥���� " + money / coin + "��. ");
			money %= coin;
		} 
		// for�Ϲݱ���
//		for(int i=0 ; i<coinUnit.length ; i++) {
//			System.out.print(coinUnit[i]+"�� ¥���� "+(money/coinUnit[i])+ "��, ");
//			money %= coinUnit[i]; //money = money%coinUnit[i];	
//		}
	}
}
