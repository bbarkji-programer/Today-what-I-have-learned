package com.tj.ex03_math;

import java.util.Random;

public class Ex05_Lotto {

	public static void main(String[] args) {
		byte[] lotto = new byte[6];
		Random random = new Random();
		random.nextBytes(lotto); // byte �迭�� ��� �濡 byte ������ �ִ´�.(-128���� 127����)
		for(int i=0 ; i<lotto.length ; i++) {
			int temp = Math.abs(lotto[i]); // 0~128 ����
			lotto[i] = (byte)(temp%45 +1);
		}
		for(byte l : lotto) {
			System.out.println(l);
		}
	}
}
