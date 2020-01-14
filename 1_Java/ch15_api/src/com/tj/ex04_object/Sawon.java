package com.tj.ex04_object;

public class Sawon {

	private String no;
	private String name;
	
	public Sawon(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "[사번]"+no+" [이름]"+name;
	}
	
	
}
