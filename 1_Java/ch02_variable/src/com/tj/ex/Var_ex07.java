package com.tj.ex;

public class Var_ex07 {
	public static void main(String[] args) {
		byte b = 10;
		double d = 10; //왼쪽 공간이 더 많으면 형 변환이 필요없다 d=10.0 <- 묵시적 형변환
		double d2 = 10.91; 
		int i = (int)d2; //4byte < 8byte 이기 때문에 (int)필요 <- 명시적 형변환(*데이터 손실이 생길 수 있다.)
		//i = (10+20+30)/7; //정수끼리 연산하면 정수로만 나옴. 소수 하고 싶으면 뒤에 .0 붙여야 한다.
	}
}
