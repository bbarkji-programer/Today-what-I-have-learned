package com.tj.ex02_throws;

public class ThrowsEx {
	public ThrowsEx() throws ArrayIndexOutOfBoundsException { // �����ڸ���
		actionC();
	}
	private void actionC() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionC ���ݺ�");
		actionB();
		
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB ���ݺ�");
		actionA();
		System.out.println("actionB �Ĺݺ�");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA ���ݺ�");
		int[] iArr = {0,1,2};
//		try{
			System.out.println("iArr[3] = "+iArr[4]);
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("���ܸ޽���: "+e.getMessage());
//		}
		System.out.println("actionA �Ĺݺ�");
	}
}

