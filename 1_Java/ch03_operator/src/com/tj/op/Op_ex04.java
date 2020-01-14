package com.tj.op;
// 논리연산자 (AND, OR)
public class Op_ex04 {
	public static void main(String[] args) {
	System.out.println("* * *논리 연산자* * *");
	//(AND, OR => &&, ||)
	
		int i=1, j=10, h=10;
		System.out.println("&&(AND) (i>j) && (++j>h) : "+((i>j) && (++j>h)));
		//                                                  F   &&  T   && 연산에서 앞이 F가 나오면 뒤에 계산 안함 -> j++ 안함
		System.out.println(j);
		
		System.out.println("||(AND) (i>j) || (++j>h) : "+((i<j) || (++j>h)));
		//                                                  T   ||  T   || 연산에서는 앞이 F가 나와도 뒤에 계산 함 / 앞이 T 이면 뒤에 연산 안함. -> j++ 안함
		System.out.println(j);
		
		
}
}
 