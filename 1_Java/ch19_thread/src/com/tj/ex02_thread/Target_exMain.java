package com.tj.ex02_thread;

public class Target_exMain {
	public static void main(String[] args) {
		// Thread를 extends 한거니까 따로 Runnable 생성자 필요없고,(선언필요없고)
		// 쓰레드 생성과 동시에 run()이 이미 정의 됨.
		Thread threadC = new Target_ex01();
//		threadC.setName("C"); // 꼭 정의는 안해도 되긴 됨. 그럼 알아서 이름 붙임.
		Thread threadD = new Target_ex02(); 
//		threadD.setName("D");
		threadC.start(); // start는 꼭 해줘야함.
		threadD.start();
		
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"쓰레드"); // 현재 쓰레드 네임
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
