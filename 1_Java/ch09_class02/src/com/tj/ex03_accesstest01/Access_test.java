package com.tj.ex03_accesstest01;

public class Access_test {
	
	private int privateMember = 10;
	int defaultMember = 20;
	protected int protectedMember = 30;
	public int publicMember = 40;
	
	private void privateMethod() {
		System.out.println("private Methiod");
	}
	void defaultMethod() {
		System.out.println("default Method");
	}
	protected void protectedMethod() {
		System.out.println("protected method");
	}
	public void publicMethod() {
		System.out.println("public method");
	}
}
