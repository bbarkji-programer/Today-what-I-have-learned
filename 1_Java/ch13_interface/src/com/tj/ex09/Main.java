package com.tj.ex09;

public class Main {

	public static void main(String[] args) {
		
//		I a = new A(); -> A method() ���
		I a = new B(); // -> B method() ���
		User user = new User();
		user.use(a);
	}
}
