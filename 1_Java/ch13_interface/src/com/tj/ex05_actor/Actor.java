package com.tj.ex05_actor;

public class Actor implements PoliceMan, FireFighter, Chef {

	private String name;
	
	public Actor() {
		
	}
	public Actor(String name) {
		this.name = name;
	}
	
	@Override
	public void makePizza() {
		System.out.println("요리사 "+name+"는 피자를 만든다.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println("요리사 "+name+"는 스파게티를 만든다.");
	}

	@Override
	public void outFire() {
		System.out.println("소방관 "+name+"가 불을 끈다.");
	}

	@Override
	public void saveMan() {
		System.out.println("소방관 "+name+"가 사람을 구한다.");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println("경찰관 "+name+"는 범인을 잡을 수 있다.");
	}

	@Override
	public void canSearch() {
		System.out.println("경찰관 "+name+"는 물건을 찾을 수 있다.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
