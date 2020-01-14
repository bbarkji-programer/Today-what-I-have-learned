package com.tj.ex03_math;

import java.util.Random;

public class Ex05_Lotto {

	public static void main(String[] args) {
		byte[] lotto = new byte[6];
		Random random = new Random();
		random.nextBytes(lotto); // byte 배열의 모든 방에 byte 난수를 넣는다.(-128부터 127까지)
		for(int i=0 ; i<lotto.length ; i++) {
			int temp = Math.abs(lotto[i]); // 0~128 까지
			lotto[i] = (byte)(temp%45 +1);
		}
		for(byte l : lotto) {
			System.out.println(l);
		}
	}
}
