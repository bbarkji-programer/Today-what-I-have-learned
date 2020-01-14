package com.tj.ex01_runnable;

public class Target_exMain {
	public static void main(String[] args) {
		Runnable target01 = new Target_ex01();
		Runnable target02 = new Target_ex02();
		Thread threadA = new Thread(target01, "A"); // target01(new Target_ex01())�� run() �۾��� �ϴ� "A" ������ ����
		Thread threadB = new Thread(target02, "B"); // target02�� run() �۾��� �ϴ� "B" ������ ����
		threadA.start(); // ������A ����
		threadB.start(); // ������B ����
		
		for(int i=0 ; i<10 ; i++) {
			System.out.println("���� main ������");
				try {
					Thread.sleep(500);						
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
			}
		}
	}
}
