package com.tj.ex;

public class Var_ex06 {
	public static void main(String[] args) {
		float f1=10.1f, f2=100.1F;
		System.out.printf("f1 = %5.1f\n", f1);
		System.out.printf("f2 = %5.1f\n", f2); //%몇자리표현.소수점어디까지f\n
		f1 = 10.0000017f;
		double d = 10.0000017; //소수점은 double
		System.out.printf("f1 = %5.2f\n",f1);
		System.out.printf("d = %5.2f\n", d);
		System.out.println("f1="+f1);
		System.out.println("d="+d);
		if(f1==d)
			System.out.println("f1과 d는 같다");
		else
			System.out.println("f1과 d는 다르다");
			}
}
