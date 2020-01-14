package com.tj.ex04_objectNThreadN;

public class ThreadEx02 extends Thread {
	
	private int num = 0;
	
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
