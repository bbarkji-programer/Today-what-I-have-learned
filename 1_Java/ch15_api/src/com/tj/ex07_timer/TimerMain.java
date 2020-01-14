package com.tj.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // Timer(true) : 프로그램 종료 시 timer는 메모리에 상주하지 않는다.(타이머가 중단된다.)
		TimerTask task1 = new TimerTaskEx01();
		TimerTask task2 = new TimerTaskEx02();
		timer.schedule(task1,2000); // task1을 2000밀리세컨 뒤에 한 번 실행
		timer.schedule(task2, 1000, 500); // task2는 1000밀리세컨 뒤부터 500밀리세컨 마다 실행		
		Thread.sleep(11000);
		System.out.println("끝");
	}
}
