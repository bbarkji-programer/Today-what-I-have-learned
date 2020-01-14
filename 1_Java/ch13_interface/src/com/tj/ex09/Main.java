package com.tj.ex09;

public class Main {

	public static void main(String[] args) {
		
//		I a = new A(); -> A method() 출력
		I a = new B(); // -> B method() 출력
		User user = new User();
		user.use(a);
	}
}
