package com.tj.ex02_thread;
// �ȳ��ϼ��� 10�� �ϴ� target ����
public class Target_ex01 extends Thread {
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("�ȳ��ϼ���");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
