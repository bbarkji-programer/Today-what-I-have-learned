package com.tj.ex03_object1ThreadN;
// Thread N���� ��ü(object) 1��
public class ThreadEx implements Runnable {
	
	private int num = 0; // ��������. Thread �ȿ� ����ִ� ��ü ����. 
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("~ ~ ~ A ������ ���� �� ~ ~ ~");
				num++;
			}
			System.out.println(Thread.currentThread().getName()+"�� num="+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
