package com.tj.ex02_thread;
// 안녕하세요 10번 하는 target 정의
public class Target_ex01 extends Thread {
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("안녕하세요");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
