package com.tj.ex03_exceptionexs;
// java.lang.NumberFormatException
public class Ex01 {
	public static void main(String[] args) {
		String korstr = "    100 ";
		int kor = Integer.parseInt(korstr.trim());
		System.out.println(kor);
	}

}
