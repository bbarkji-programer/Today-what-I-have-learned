package com.tj.ex02_thread;
// �ݰ����ϴ� 10�� �ϴ� tartget ����
public class Target_ex02 extends Thread {
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("�ݰ����ϴ�.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
