package com.tj.ex01_runnable;
// �ȳ��ϼ��� 10�� �ϴ� target ����
public class Target_ex01 implements Runnable {

	@Override
	public void run() { 
		for(int i=0 ; i<10 ; i++) {
			System.out.println("�ȳ��ϼ���.");
			try { // ���� �۾��� 0.5��(500�и�����)���� �����·�(�ȳ��ϼ��� �ϰ� 0.5�� ����,)
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
