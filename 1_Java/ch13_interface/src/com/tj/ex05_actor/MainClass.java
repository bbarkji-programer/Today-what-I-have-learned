package com.tj.ex05_actor;

public class MainClass {

	public static void main(String[] args) {
		
		Actor gong = new Actor("����"); // Actor�� ����
		
		gong.outFire();
		gong.saveMan();
		gong.makePizza();
		gong.makeSpaghetti();
		gong.canCatchCriminal();
		gong.canSearch(); // �׷��� 6���� ��� ����!
		
		System.out.println("------------------------");
		
		FireFighter fireGong = gong; // FireFighter�� ����
		fireGong.outFire();
		fireGong.saveMan(); // �׷��� �� ������ ����!
		
		System.out.println("------------------------");
		
		PoliceMan policeGong = gong; // PoliceMan�� ����
		policeGong.canCatchCriminal();
		policeGong.canSearch(); // �׷��� �� ������ ����!
		
		System.out.println("------------------------");
		
		Chef chefGong = gong; // Chef�� ����
		chefGong.makePizza();
		chefGong.makeSpaghetti(); // �׷��� �� ������ ����!
	}
}
