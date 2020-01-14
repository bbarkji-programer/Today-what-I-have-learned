package com.tj.ex03_object1ThreadN;
// Thread N개에 객체(object) 1개
public class ThreadEx implements Runnable {
	
	private int num = 0; // 공유변수. Thread 안에 들어있는 객체 공유. 
	
	@Override
	public void run() {
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
