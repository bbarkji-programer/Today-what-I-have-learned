package com.tj.ex05;

public class Ex01 {
	public static void main(String[] args) {
		Runnable target = new Thread01();
		Thread th1 = new Thread(target);
		th1.start();
		for(int i=0 ; i<300 ; i++) {
			System.out.print('¡Ú');
		}
		
	}
}
