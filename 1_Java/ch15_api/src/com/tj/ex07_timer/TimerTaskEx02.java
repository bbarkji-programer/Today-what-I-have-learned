package com.tj.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx02 extends TimerTask {

	@Override
	public void run() {
		//할 일을 정의해준다.
		System.out.println("♥♥♥TimerTaskEx02 작업 실행 중♥♥♥(1초 후 0.5초 마다 실행 예정)");

	}

}
