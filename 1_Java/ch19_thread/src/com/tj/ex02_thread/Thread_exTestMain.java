package com.tj.ex02_thread;

public class Thread_exTestMain {
	public static void main(String[] args) {
		Thread_ex threadA = new Thread_ex("A"); // 매개변수 String name 있는 생성자 활용
		Thread_ex threadB = new Thread_ex(); // 매개변수 없는 생성자 활용
		threadB.setName("B"); // 이건 해도 되고, 안해도 됨.
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main함수 끝.");
	}
}
