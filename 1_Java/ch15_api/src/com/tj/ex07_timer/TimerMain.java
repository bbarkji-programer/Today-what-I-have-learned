package com.tj.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); // Timer(true) : ���α׷� ���� �� timer�� �޸𸮿� �������� �ʴ´�.(Ÿ�̸Ӱ� �ߴܵȴ�.)
		TimerTask task1 = new TimerTaskEx01();
		TimerTask task2 = new TimerTaskEx02();
		timer.schedule(task1,2000); // task1�� 2000�и����� �ڿ� �� �� ����
		timer.schedule(task2, 1000, 500); // task2�� 1000�и����� �ں��� 500�и����� ���� ����		
		Thread.sleep(11000);
		System.out.println("��");
	}
}
