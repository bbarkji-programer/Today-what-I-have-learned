package com.tj.ex01_runnable;
// 지역변수면 문제 없음
public class Thread_ex implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread_ex");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"쓰레드의 i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
