package com.tj.ex06;

public class ChildClass extends ParentClass { // method1(), method2() ��ӹ���
	public ChildClass() { // overloading(�Լ��� �ߺ�����)
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int t) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	@Override
	public void method1() { // override(�Լ��� ������)
		System.out.println("ChildClass�� method1()");
	}
	public void method3() {
		System.out.println("ChildClass�� method3()");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
