package com.tj.ex03_set;

import java.util.HashSet;
import java.util.Random;

public class Ex03_hashSet_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		while(lotto.size()<6) { // 6�� �Ǵ� ���� ������ϴϱ�.
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
	}
}
