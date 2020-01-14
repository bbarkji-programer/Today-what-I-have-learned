package com.tj.q01;

public class Person {

	private String id;
	private String name;
	
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String infoString() {
		return "[아이디]"+id+" [이름]"+name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
	