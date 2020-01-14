package com.tj.ex05;

public class Thread01 implements Runnable {

	@Override
	public void run() {
		for(int i=0 ; i<300 ; i++) {
			System.out.print('-');
		}

	}

}
