package com.tj.ex05_actor;

public class MainClass {

	public static void main(String[] args) {
		
		Actor gong = new Actor("공유"); // Actor형 변수
		
		gong.outFire();
		gong.saveMan();
		gong.makePizza();
		gong.makeSpaghetti();
		gong.canCatchCriminal();
		gong.canSearch(); // 그래서 6가지 모두 가능!
		
		System.out.println("------------------------");
		
		FireFighter fireGong = gong; // FireFighter형 변수
		fireGong.outFire();
		fireGong.saveMan(); // 그래서 두 가지만 가능!
		
		System.out.println("------------------------");
		
		PoliceMan policeGong = gong; // PoliceMan형 변수
		policeGong.canCatchCriminal();
		policeGong.canSearch(); // 그래서 두 가지만 가능!
		
		System.out.println("------------------------");
		
		Chef chefGong = gong; // Chef형 변수
		chefGong.makePizza();
		chefGong.makeSpaghetti(); // 그래서 두 가지만 가능!
	}
}
