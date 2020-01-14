package com.tj.ex02_throws;

public class Main {
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
//		try {
			new ThrowsEx(); // 객체만 만듬			
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("던진 예외 여기서 보험들음"); 
			// 예외가 발생할만한 것들은 최소한 메인에서는 처리해야. JVM은 예외처리를 해주지 않는다.
//		}
	}
}