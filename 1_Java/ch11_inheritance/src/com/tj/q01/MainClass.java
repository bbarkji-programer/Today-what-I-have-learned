package com.tj.q01;

public class MainClass {
	public static void main(String[] args) {
		
		Student st1 = new Student("A01", "������", "JAVA��");
		Student st2 = new Student("A02", "ȫ�浿", "C++��");
		Staff sf1 = new Staff("S01", "���浿", "�������");
		Staff sf2 = new Staff("S02", "���ε�", "���������");
		Gangsa ga1 = new Gangsa("G01", "�̱浿", "��ü����");
		
		Person[] person = {st1, st2, sf1, sf2, ga1};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		
	}
}
