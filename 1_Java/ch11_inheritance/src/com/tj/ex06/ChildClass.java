package com.tj.ex06;

public class ChildClass extends ParentClass { // method1(), method2() 상속받음
	public ChildClass() { // overloading(함수의 중복정의)
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int t) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	@Override
	public void method1() { // override(함수의 재정의)
		System.out.println("ChildClass의 method1()");
	}
	public void method3() {
		System.out.println("ChildClass의 method3()");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
