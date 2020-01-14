package com.tj.ex06_override_overlod;
// method 이름은 똑같은데 생성자 타입 or 매개변수 타입으로 구분한다.
public class OverloadingTest {

	private int i1;
	private int i2;
	
	//생성자 Overloading
	public OverloadingTest() {
	}
	public OverloadingTest(int i) {
		i1 = i2 = i;
	}
	public OverloadingTest(int i1, int i2) {
		super();
		this.i1 = i1;
		this.i2 = i2;
	}
	public void calculate() { // 일반함수의 오버로딩
		System.out.println("i1+i2="+(i1+i2));
	}
	public void calculate(char op) { // 객체이름.calculate() 객체이름.calculate('*')
		switch(op) {
		case '+' :
			calculate();
			break;
		case '-' :
			System.out.println("i1-i2="+(i1-i2));
			break;
		case '*' :
			System.out.println("i1*i2="+(i1-i2));
			break;
		case '/' :
			System.out.println("i1/i2="+(i1/i2));
			break;
		case '%' :
			System.out.println("i1%i2="+(i1%i2));
			break;
		default:
			System.out.println("유효하지 않은 연산자입니다.");
			break;
		}
	}
	
	
	
}
