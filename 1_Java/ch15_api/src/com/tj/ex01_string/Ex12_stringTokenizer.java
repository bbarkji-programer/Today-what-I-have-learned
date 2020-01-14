package com.tj.ex01_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {

	public static void main(String[] args) {
		
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2019/12/10";
		StringTokenizer tokenizer1 = new StringTokenizer(str1); // 띄어쓰기(white space)로 token 구분
		StringTokenizer tokenizer2 = new StringTokenizer(str2,"/");
		System.out.println("t1의 토큰갯수: "+tokenizer1.countTokens());
		System.out.println("t2의 토큰갯수: "+tokenizer2.countTokens());
		while(tokenizer1.hasMoreTokens()) { // 포인트가 가르키는 곳에 토큰을 갖고 있니? // 그 다음 가르킬 때가 없을 때는 false가 되서 실행안함.
			System.out.println(tokenizer1.nextToken()); // 출력(그 토큰을 가져오고 다음 토큰 가르켜)
		}
		while(tokenizer2.hasMoreTokens()) { 
			System.out.println(tokenizer2.nextToken());
		}

	}
}
