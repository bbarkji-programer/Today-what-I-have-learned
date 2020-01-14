package com.tj.ex04_objectNThreadN;

public class ThreadEx02TestMain {
	public static void main(String[] args) {
		ThreadEx02 threadA = new ThreadEx02();
		threadA.setName("A");
		ThreadEx02 threadB = new ThreadEx02();
		threadB.setName("B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main�Լ� ���� �� : A�� num="+threadA.getNum());
		System.out.println("main�Լ� ���� �� : B�� num="+threadB.getNum());
		}		
	}

