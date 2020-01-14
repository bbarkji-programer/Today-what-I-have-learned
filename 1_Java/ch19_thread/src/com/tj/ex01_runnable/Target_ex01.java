package com.tj.ex01_runnable;
// 안녕하세요 10번 하는 target 정의
public class Target_ex01 implements Runnable {

	@Override
	public void run() { 
		for(int i=0 ; i<10 ; i++) {
			System.out.println("안녕하세요.");
			try { // 현재 작업을 0.5초(500밀리세컨)동안 대기상태로(안녕하세요 하고 0.5초 쉬고,)
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
