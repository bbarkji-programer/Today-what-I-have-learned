package com.tj.ex08_super;

public class Person_main {
	public static void main(String[] args) {
		
		Person papa = new Person();
		papa.setName("�ƺ� ��");
		papa.setCharacter("�׶���~");
		papa.intro();
		
		Person mom = new Person("���� ��", "������~");
		mom.intro();
		
		Baby child1 = new Baby();
		child1.setName("�Ʊ� ��");
		child1.setCharacter("�ʹ� �Ϳ���~");
		child1.intro();
		
		System.out.println("***********************");
		Baby child2 = new Baby("�Ʊ� ��2", "�ʹ��ʹ��ʹ� �Ϳ���!");
		child2.intro();
	}
}
