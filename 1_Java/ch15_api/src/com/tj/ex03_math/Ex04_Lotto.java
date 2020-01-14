package com.tj.ex03_math;

import java.util.Random;

public class Ex04_Lotto {

	public static void main(String[] args) {
		
		byte[] lotto = new byte[6];
		Random random = new Random();
		int j=0;
		
		for(int i=0 ; i<lotto.length ; i++) {
			byte temp = (byte)(random.nextInt(45)+1); // �ߺ����� �����Ǹ� �ȵǴϱ� temp
			for(j=0 ; j<i ; j++) { // �ߺ�Ȯ��. j�� �׻� i ���� �ϳ� �۾����ϱ�, j<i (�ι�° �̴°� ù ��° �̴°Ŷ� ��, ����° �̴°� ù��° �ι�° ���� �Ͱ� ��
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
