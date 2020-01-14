package com.tj.ex02_thread;
// Thread_ex threadA = new Thread_ex("A");
// threadA.setName("A")
//=> Tread_ex threadA = new Thread_ex("A");

public class Thread_ex extends Thread {
	public Thread_ex() {
		this(""); // super()�� �ϸ� �ȵ�. �׷� �ؿ� �۾��� ���ع���.
	}
	public Thread_ex(String name) {
		super(name); // extends ���� super���� ������. ù ��° �ܿ� ����. ������ �̸� ���. setName�� ���� ȿ��.
	}
	@Override
	public void run() { // ���ÿ� �ϰ� ���� ���� run �������̵忡�� 
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread_ex");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"�������� i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
