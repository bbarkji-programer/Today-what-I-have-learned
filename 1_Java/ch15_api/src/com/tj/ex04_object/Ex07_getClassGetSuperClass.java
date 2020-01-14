package com.tj.ex04_object;

public class Ex07_getClassGetSuperClass {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10, 5, "black");
		Class cls = obj.getClass();
		System.out.println(cls.getName()); // com.tj.ex04_object.Rectangle
		// Rectangle
		System.out.println(cls.getName().substring(cls.getName().lastIndexOf('.')+1));
		Class superCls = cls.getClass().getSuperclass();
		System.out.println(superCls.getName());
		
	}
}
