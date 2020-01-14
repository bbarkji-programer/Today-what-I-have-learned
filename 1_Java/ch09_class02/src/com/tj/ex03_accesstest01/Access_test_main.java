package com.tj.ex03_accesstest01;

public class Access_test_main {
	public static void main(String[] args) {
		Access_test obj = new Access_test();
		// System.out.println(obj.privateMember);
		// obj.privateMethod();
		System.out.println(obj.defaultMember);
		obj.defaultMethod(); // default는 같은 패키지에서 접근 허용
		System.out.println(obj.protectedMember);
		obj.protectedMethod(); // 같은 패키지거나 상속받았으면 가능
		System.out.println(obj.publicMember);
		obj.publicMethod(); // 접근 제한 없음
	}
}
