package com.tj.ex;

//오늘의 문제6) 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄때 몇개씩 주어야 하나?
//		        힌트 :  coinUnit[i] + “원 ; ” + money/coinUnit[i]        
//			 money = money%coinUnit[i];

public class Array_ex11 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coinUnit = { 500, 100, 50, 10 };
		// for확장구문
		for (int coin : coinUnit) {
			System.out.print(coin + "원 짜리는 " + money / coin + "개. ");
			money %= coin;
		} 
		// for일반구문
//		for(int i=0 ; i<coinUnit.length ; i++) {
//			System.out.print(coinUnit[i]+"원 짜리는 "+(money/coinUnit[i])+ "개, ");
//			money %= coinUnit[i]; //money = money%coinUnit[i];	
//		}
	}
}
