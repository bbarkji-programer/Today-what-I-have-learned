package com.tj.ex04_objectNThreadN;

public class ThreadEx01 implements Runnable {

	private int num = 0; // 공유변수. Thread 안에 들어있는 객체 공유. 
	
	@Override
	public void run() { // 동시에 하고 싶은 행동을 여기에
		for(int i=0 ; i<10 ; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("~ ~ ~ A 쓰레드 실행 중 ~ ~ ~");
				num++;
			}
			System.out.println(Thread.currentThread().getName()+"의 num="+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

