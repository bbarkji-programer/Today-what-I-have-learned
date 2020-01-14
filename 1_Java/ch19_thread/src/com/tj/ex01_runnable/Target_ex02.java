package com.tj.ex01_runnable;
// 반값습니다 10번 하는 target 정의
public class Target_ex02 implements Runnable {

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
