package com.tj.ex03_accesstest01;

public class Access_test_main {
	public static void main(String[] args) {
		Access_test obj = new Access_test();
		// System.out.println(obj.privateMember);
		// obj.privateMethod();
		System.out.println(obj.defaultMember);
		obj.defaultMethod(); // default�� ���� ��Ű������ ���� ���
		System.out.println(obj.protectedMember);
		obj.protectedMethod(); // ���� ��Ű���ų� ��ӹ޾����� ����
		System.out.println(obj.publicMember);
		obj.publicMethod(); // ���� ���� ����
	}
}
