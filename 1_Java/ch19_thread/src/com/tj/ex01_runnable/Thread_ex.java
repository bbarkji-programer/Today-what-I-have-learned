package com.tj.ex01_runnable;
// ���������� ���� ����
public class Thread_ex implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread_ex");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"�������� i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
