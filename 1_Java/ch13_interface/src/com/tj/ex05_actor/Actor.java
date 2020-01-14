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
		System.out.println("�丮�� "+name+"�� ���ڸ� �����.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println("�丮�� "+name+"�� ���İ�Ƽ�� �����.");
	}

	@Override
	public void outFire() {
		System.out.println("�ҹ�� "+name+"�� ���� ����.");
	}

	@Override
	public void saveMan() {
		System.out.println("�ҹ�� "+name+"�� ����� ���Ѵ�.");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println("������ "+name+"�� ������ ���� �� �ִ�.");
	}

	@Override
	public void canSearch() {
		System.out.println("������ "+name+"�� ������ ã�� �� �ִ�.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
