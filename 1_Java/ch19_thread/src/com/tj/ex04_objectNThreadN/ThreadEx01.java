package com.tj.ex04_objectNThreadN;

public class ThreadEx01 implements Runnable {

	private int num = 0; // ��������. Thread �ȿ� ����ִ� ��ü ����. 
	
	@Override
	public void run() { // ���ÿ� �ϰ� ���� �ൿ�� ���⿡
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

