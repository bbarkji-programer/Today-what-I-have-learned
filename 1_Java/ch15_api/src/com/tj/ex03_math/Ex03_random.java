package com.tj.ex03_math;

import java.util.Random;

public class Ex03_random {

	public static void main(String[] args) {
		
		System.out.println(Math.random());
		Random random = new Random();
		System.out.println("int 난수: "+random.nextInt());
		System.out.println("double 난수: "+random.nextDouble()); // == Math.random()
		System.out.println("T/F 난수: "+random.nextBoolean());
		System.out.println("long 난수: "+random.nextLong());
		System.out.println("float 난수: "+random.nextFloat());
		System.out.println("0~100까지 정수 난수: "+random.nextInt(101));
		System.out.println("0~44까지 정수 난수: "+random.nextInt(45));
		System.out.println("1~45까지의 정수 난수: "+(random.nextInt(45)+1));
		
	}
}
