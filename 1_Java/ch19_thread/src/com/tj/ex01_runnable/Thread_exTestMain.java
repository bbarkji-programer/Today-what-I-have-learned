package com.tj.ex01_runnable;

public class Thread_exTestMain {
	public static void main(String[] args) {
		Runnable target = new Thread_ex();
		Thread threadA = new Thread(target,"A"); 
		Thread threadB = new Thread(target,"B"); // A와B가 같은 target 공유(지역변수면 문제가 없다.)
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main함수 끝.");
	}
}
