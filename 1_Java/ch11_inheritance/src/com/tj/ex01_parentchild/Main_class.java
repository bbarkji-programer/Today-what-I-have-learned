package com.tj.ex01_parentchild;

public class Main_class {
	public static void main(String[] args) {
		Child_class child = new Child_class();
		child.getMamiName();
		child.getPapaName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}
