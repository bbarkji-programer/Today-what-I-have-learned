package com.tj.ex03_math;

import java.util.Random;

public class Ex03_random {

	public static void main(String[] args) {
		
		System.out.println(Math.random());
		Random random = new Random();
		System.out.println("int ����: "+random.nextInt());
		System.out.println("double ����: "+random.nextDouble()); // == Math.random()
		System.out.println("T/F ����: "+random.nextBoolean());
		System.out.println("long ����: "+random.nextLong());
		System.out.println("float ����: "+random.nextFloat());
		System.out.println("0~100���� ���� ����: "+random.nextInt(101));
		System.out.println("0~44���� ���� ����: "+random.nextInt(45));
		System.out.println("1~45������ ���� ����: "+(random.nextInt(45)+1));
		
	}
}
