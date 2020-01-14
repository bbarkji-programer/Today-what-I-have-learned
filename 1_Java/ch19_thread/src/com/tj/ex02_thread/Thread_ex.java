package com.tj.ex02_thread;
// Thread_ex threadA = new Thread_ex("A");
// threadA.setName("A")
//=> Tread_ex threadA = new Thread_ex("A");

public class Thread_ex extends Thread {
	public Thread_ex() {
		this(""); // super()로 하면 안됨. 그럼 밑에 작업을 안해벌임.
	}
	public Thread_ex(String name) {
		super(name); // extends 받은 super단의 생성자. 첫 번째 단에 실행. 쓰레드 이름 명명. setName과 같은 효과.
	}
	@Override
	public void run() { // 동시에 하고 싶은 것은 run 오버라이드에서 
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread_ex");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"쓰레드의 i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
