package com.tj.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx01 extends TimerTask {

	@Override
	public void run() { 
		//할 일을 정의해준다.
		System.out.println("★★★TimerTaskEx01 작업 실행 중★★★(2초 후 1번 실행 예정)");

	}

}
