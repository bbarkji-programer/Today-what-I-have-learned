package com.tj.ex03;

public class MainClass {
	
	public static void main(String[] args) {
		
		InterfaceClass ifc = new InterfaceClass();
			ifc.calculate();
			ifc.getStr();
			ifc.toString(); // Object���� �ڵ����� ��� ����.
		
		System.out.println("[interfaceEx01�� ����]-----------------------");
		
		InterfaceEx01 if1 = new InterfaceClass();
			if1.calculate();
//			if1.getStr(); if1�� InterfaceEx01�� ������ ������ ����.
		
		System.out.println("[interfaceEx02�� ����]-----------------------");
			
		InterfaceEx02 if2 = new InterfaceClass();
//			if2.calculate(); if2�� InterfaceEx02�� ������ ������ ����.
			if2.getStr();
		
		System.out.println("InterfaceEx01 ���: "+InterfaceEx01.CONSTANT_NUM);
		System.out.println("InterfaceClass ���: "+InterfaceClass.CONSTANT_NUM);
		System.out.println("InterfaceEx02 ���: "+InterfaceEx02.CONSTANT_STRING);
		System.out.println("InterfaceClass ���: "+InterfaceEx02.CONSTANT_STRING);
	}

}
