package com.tj.ex03;

public class MainClass {
	
	public static void main(String[] args) {
		
		InterfaceClass ifc = new InterfaceClass();
			ifc.calculate();
			ifc.getStr();
			ifc.toString(); // Object에서 자동으로 상속 받음.
		
		System.out.println("[interfaceEx01형 변수]-----------------------");
		
		InterfaceEx01 if1 = new InterfaceClass();
			if1.calculate();
//			if1.getStr(); if1이 InterfaceEx01형 변수라서 컴파일 오류.
		
		System.out.println("[interfaceEx02형 변수]-----------------------");
			
		InterfaceEx02 if2 = new InterfaceClass();
//			if2.calculate(); if2가 InterfaceEx02형 변수라서 컴파일 오류.
			if2.getStr();
		
		System.out.println("InterfaceEx01 상수: "+InterfaceEx01.CONSTANT_NUM);
		System.out.println("InterfaceClass 상수: "+InterfaceClass.CONSTANT_NUM);
		System.out.println("InterfaceEx02 상수: "+InterfaceEx02.CONSTANT_STRING);
		System.out.println("InterfaceClass 상수: "+InterfaceEx02.CONSTANT_STRING);
	}

}
