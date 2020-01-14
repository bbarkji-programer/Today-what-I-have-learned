package com.tj.ex07_synchronized;
// Thread N���� ��ü(object) 1��
public class ThreadEx implements Runnable {
	
	private int num = 0; // ��������. Thread �ȿ� ����ִ� ��ü ����. 
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private synchronized void out() {
		if(Thread.currentThread().getName().equals("A")) {
			System.out.println("~ ~ ~ A ������ ���� �� ~ ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName()+"�� num="+num);
		
	}

}
