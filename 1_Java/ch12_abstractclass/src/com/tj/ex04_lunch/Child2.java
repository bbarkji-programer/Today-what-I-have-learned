package com.tj.ex04_lunch;

public class Child2 extends LunchMenu {
	
	public Child2(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		super(rice, bulgogi, soup, milk, banana, almond);
		setStr("Child2�� �Ĵ�: ");
	}

	@Override
	public int calculate() {
		// ��+�Ұ��+��+����
		return getRice()+getBulgogi()+getSoup()+getMilk();
	}

}
