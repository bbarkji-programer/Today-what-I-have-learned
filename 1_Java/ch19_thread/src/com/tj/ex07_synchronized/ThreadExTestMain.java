package com.tj.ex07_synchronized;

public class ThreadExTestMain {
	public static void main(String[] args) {
		Runnable target = new ThreadEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B"); // target 하나를 공유
		threadA.start();
		threadB.start();
		System.out.println("main함수 끝.");
	}
}
