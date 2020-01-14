package com.tj.ex04_man;

public class Man_main {
	public static void main(String[] args) {
		Man park = new Man(168, 57);
		// park : 객체변수 = 레퍼런스 변수 = 객체
		Man jeon = new Man();
		jeon.setHeight(183); // 정보가 없으니, 셋팅이 필요한 것.
		jeon.setWeight(81);
		Man lee = new Man(183, 75);
		if(jeon.equals(lee)) {
			System.out.println("jeon 객체변수와 lee 객체변수는 같다.");
		}else {
			System.out.println("jeon 객체변수와 lee 객체변수는 다르다.");
		}
		jeon = lee;
		if(jeon.equals(lee)) {
			System.out.println("jeon 객체변수와 lee 객체변수는 같다.");
		}else {
			System.out.println("jeon 객체변수와 lee 객체변수는 다르다.");
		}
		double biman = park.calculateBMI();
		if(biman>24) {
			System.out.println("park님은 비만입니다.");
		}else {
			System.out.println("park님은 비만은 아닙니다.");
		}
		biman = jeon.calculateBMI();
		if(biman>24) {
			System.out.println("jeon님은 비만입니다.");
		}else {
			System.out.println(jeon.getClass().getName()+" jeon 님은 비만은 아니네요.");
		}
	}
}
