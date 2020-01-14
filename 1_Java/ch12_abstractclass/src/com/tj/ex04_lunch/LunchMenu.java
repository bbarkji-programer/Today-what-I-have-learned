package com.tj.ex04_lunch;

public abstract class LunchMenu {
	private String str;
	private int rice; // 밥값
	private int bulgogi; // 불고기값
	private int soup; // 국값
	private int milk; //우유값
	private int banana; // 바나나값
	private int almond; //아몬드
	
	// Child c = new Child(PriceTable.RICE, 500, 100, 750, 600, 100) <- main 함수에서 이렇게 객체 만들것.
	public LunchMenu(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.milk = milk;
		this.banana = banana;
		this.almond = almond;
	}
	public abstract int calculate();
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	public int getRice() {
		return rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public int getMilk() {
		return milk;
	}
	public int getBanana() {
		return banana;
	}
	public int getAlmond() {
		return almond;
	}
	
}
