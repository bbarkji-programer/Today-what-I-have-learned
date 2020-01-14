package com.tj.ex03_math;

import java.util.Random;

public class Ex04_Lotto {

	public static void main(String[] args) {
		
		byte[] lotto = new byte[6];
		Random random = new Random();
		int j=0;
		
		for(int i=0 ; i<lotto.length ; i++) {
			byte temp = (byte)(random.nextInt(45)+1); // 중복으로 생성되면 안되니까 temp
			for(j=0 ; j<i ; j++) { // 중복확인. j는 항상 i 보다 하나 작아지니까, j<i (두번째 뽑는건 첫 뻔째 뽑는거랑 비교, 세번째 뽑는건 첫번째 두번째 뽑은 것과 비교
				if(lotto[j]==temp) {
					i--;
					//break;
				}
			}
			if(i==j) {
				lotto[i] = temp;
			}
			System.out.println(temp);
		}
		
	}
}
