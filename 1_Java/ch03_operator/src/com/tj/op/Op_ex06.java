package com.tj.op;
// 할당(대입)연산자
public class Op_ex06 {
	public static void main(String[] args) {
		System.out.println("* * *할당(대입)연산자* * *");
			int n1 = 10*3; // n1=30
			n1 += 10; // n1 = n1+10 (40) // 산술연산 먼저 하고, 할당 연산을 한다. 
			n1 -= 10; // n1 = n1-10 (30)
			n1 *= 10; // n1 = n1*10 (300)
			n1 /= 10; // n1 = n1/10 (30)
			n1 %= 10; // n1 = n1%10 (0)
			System.out.println(n1);
	
	}
}
