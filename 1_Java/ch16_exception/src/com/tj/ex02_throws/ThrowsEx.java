package com.tj.ex02_throws;

public class ThrowsEx {
	public ThrowsEx() throws ArrayIndexOutOfBoundsException { // 생성자만듬
		actionC();
	}
	private void actionC() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionC 전반부");
		actionB();
		
		System.out.println("actionC 후반부");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB 전반부");
		actionA();
		System.out.println("actionB 후반부");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA 전반부");
		int[] iArr = {0,1,2};
//		try{
			System.out.println("iArr[3] = "+iArr[4]);
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("예외메시지: "+e.getMessage());
//		}
		System.out.println("actionA 후반부");
	}
}

