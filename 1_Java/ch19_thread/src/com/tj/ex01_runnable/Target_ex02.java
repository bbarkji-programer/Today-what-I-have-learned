package com.tj.ex01_runnable;
// �ݰ����ϴ� 10�� �ϴ� target ����
public class Target_ex02 implements Runnable {

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
