package com.tj.ex03_set;

import java.util.Random;
import java.util.TreeSet;

public class Ex02_TreeSet_lotto {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		while(lotto.size()<6) { // 6이 되는 순간 멈춰야하니까.
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
	}
}
