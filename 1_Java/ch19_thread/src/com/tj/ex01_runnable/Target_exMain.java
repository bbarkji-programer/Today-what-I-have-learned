package com.tj.ex01_runnable;

public class Target_exMain {
	public static void main(String[] args) {
		Runnable target01 = new Target_ex01();
		Runnable target02 = new Target_ex02();
		Thread threadA = new Thread(target01, "A"); // target01(new Target_ex01())의 run() 작업을 하는 "A" 쓰레드 생성
		Thread threadB = new Thread(target02, "B"); // target02의 run() 작업을 하는 "B" 쓰레드 생성
		threadA.start(); // 쓰레드A 실행
		threadB.start(); // 쓰레드B 실행
		
		for(int i=0 ; i<10 ; i++) {
			System.out.println("나는 main 쓰레드");
				try {
					Thread.sleep(500);						
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
			}
		}
	}
}
