package com.tj.ex02_thread;

public class Thread_exTestMain {
	public static void main(String[] args) {
		Thread_ex threadA = new Thread_ex("A"); // �Ű����� String name �ִ� ������ Ȱ��
		Thread_ex threadB = new Thread_ex(); // �Ű����� ���� ������ Ȱ��
		threadB.setName("B"); // �̰� �ص� �ǰ�, ���ص� ��.
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main�Լ� ��.");
	}
}
