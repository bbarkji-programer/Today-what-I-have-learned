package com.tj.ex02;

public abstract class SuperClass { // 추상클래스
	
	public abstract void method1(); // 추상메소드 <- 추상클래스에는 추상메소드가 1개 이상 꼭 있어야 한다.
	public void method2() {
		System.out.println("SuperClass의 method2()");
	}
}

