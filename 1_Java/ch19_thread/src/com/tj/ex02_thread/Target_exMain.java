package com.tj.ex02_thread;

public class Target_exMain {
	public static void main(String[] args) {
		// Thread�� extends �ѰŴϱ� ���� Runnable ������ �ʿ����,(�����ʿ����)
		// ������ ������ ���ÿ� run()�� �̹� ���� ��.
		Thread threadC = new Target_ex01();
//		threadC.setName("C"); // �� ���Ǵ� ���ص� �Ǳ� ��. �׷� �˾Ƽ� �̸� ����.
		Thread threadD = new Target_ex02(); 
//		threadD.setName("D");
		threadC.start(); // start�� �� �������.
		threadD.start();
		
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"������"); // ���� ������ ����
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
