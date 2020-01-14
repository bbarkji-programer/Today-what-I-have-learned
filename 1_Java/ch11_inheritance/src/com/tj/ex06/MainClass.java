package com.tj.ex06;

public class MainClass {
	public static void main(String[] args) {
		
	ParentClass parentObj = new ParentClass(2);
	parentObj.method1();
	parentObj.method2();
	System.out.println("�ڡڡڡڡڡڡ�");
	ChildClass childObj = new ChildClass(2);
	childObj.method1();
	childObj.method2();
	childObj.method3();
	
	}
}
