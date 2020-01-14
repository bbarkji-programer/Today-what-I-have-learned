package com.tj.ex03_math;

public class Ex02 {

	public static void main(String[] args) {
		
		System.out.println("[소수점 첫째 자리에서 반올림, 올림, 내림]"); 
		// 9.12 -> 9.0, 10.0, 9.0
		System.out.println("9.12를 반올림: "+Math.round(9.12)); // 9(long)
		System.out.println("9.12를 올림: "+Math.ceil(9.12)); // 10.0(double)
		System.out.println("9.12를 내림: "+Math.floor(9.12)); // 9.12(double)
		// 9.56 -> 9.6, 9.6, 9.5
		System.out.println();
		System.out.println("[소수점 둘째 자리에서 반올림, 올림, 내림]");
		System.out.println("9.56을 소수점 둘째 자리에서 반올림: "+Math.round(9.56*10)/10.0); // long/double = double 9.6
		System.out.println("9.567을 소수점 셋째 자리에서 반올림: "+Math.round(9.567*100)/100.0);
		System.out.println("9.56을 소수점 둘째 자리에서 올림: "+Math.ceil(9.56*10)/10); 
		System.out.println("9.56을 소수점 둘째 자리에서 내림: "+Math.floor(9.56*10)/10);
		// 19 -> 20, 20, 10
		System.out.println();
		System.out.println("[일의 자리에서 반올림, 올림, 내림]");
		System.out.println("19를 일의자리에서 반올림: "+Math.round(19/10.0)*10); // 20
		System.out.println("19를 일의자리에서 올림: "+Math.ceil(19/10.0)*10); //20
		System.out.println("19를 일의자리에서 내림: "+Math.floor(19/10.0)*10); 
	}
}
