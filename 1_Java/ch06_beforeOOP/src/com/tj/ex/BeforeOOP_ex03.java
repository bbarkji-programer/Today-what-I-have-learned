package com.tj.ex;

import com.tj.method.Arithmetic;

// Arithmetic���� sum, evenOdd, abs �Ẹ��
public class BeforeOOP_ex03 {
	public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmetic();
		int tot = arithmetic.sum(10, 100);
		System.out.println(arithmetic.evenOdd(tot));
		int value = Arithmetic.abs(-5);
		System.out.println("-5�� ���밪��" + value);
	}
}
