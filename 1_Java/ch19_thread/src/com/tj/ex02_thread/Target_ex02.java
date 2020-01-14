package com.tj.ex02_thread;
// 반값습니다 10번 하는 tartget 정의
public class Target_ex02 extends Thread {
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("반값습니다.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
