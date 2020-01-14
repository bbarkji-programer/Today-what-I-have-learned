package com.tj.ex06_wrapper;
// java 클래스명 100 20 10 ; 명령 파라미터로 들어온 문자열의 숫자를 합한다.
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("들어온 값 개수: "+args.length);
		//"10" "20" "3" "5" "6" "7"
		int total = 0;
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.println(args[idx]);
			total += Integer.parseInt(args[idx]); // Integer.parseInt() 숫자로 바꿀 수 있는 String만... 
		}
		System.out.println("total = "+total);
	}
}
