package com.tj.ex05_pouch;

public class Child {
	static Pouch pouch = new Pouch();
	private String name;
	public Child(String name) { // main 함수에서 Child first = new Child("첫째 길동이");
		this.name = name;
	}
	public void takeMoney(int money) {
		if(Pouch.money>=money) {
			Pouch.money = Pouch.money - money;
			System.out.println(name+"가 "+money+"원 받아가서 지갑에 "+Pouch.money+"남았다.");
		}else {
			System.out.println(money+"가 돈을 못받음. 엄마 지갑에 돈이 모자르다.");
		}
	}
}
