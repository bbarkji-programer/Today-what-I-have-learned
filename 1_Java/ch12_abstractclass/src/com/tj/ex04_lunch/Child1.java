package com.tj.ex04_lunch;

public class Child1 extends LunchMenu {
	public Child1(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		super(rice, bulgogi, soup, milk, banana, almond);
		setStr("Child1�� �Ĵ�: ");
	}

	@Override
	public int calculate() {
		// ��+�Ұ��+��+�ٳ���+�Ƹ��
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
