package com.tj.ex08_super;

public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű����� ���� Baby");
	}
	public Baby(String name, String character) {
		super(name, character);
		// super() ; �� Ŭ������ ���۴��� ������ �Լ�
//		setName(name);
//		setCharacter(character);
//		System.out.println("�Ű����� 2��¥�� Baby");		
	}
	@Override
	public void intro() {
		// super. : �� Ŭ������ ���۴���
		System.out.println("�������� �� �ֱ��");
		super.intro();
	}
}
