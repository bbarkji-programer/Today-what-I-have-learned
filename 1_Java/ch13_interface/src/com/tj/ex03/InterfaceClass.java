package com.tj.ex03;

public class InterfaceClass implements InterfaceEx01, InterfaceEx02 {

	@Override
	public String getStr() {
		System.out.println("getStr-���� ������ implements�� Ŭ���������� ����");
		return null;
	}

	@Override
	public void calculate() {
		System.out.println("calculate-���� ������ implements�� Ŭ���������� ����");

	}

}
