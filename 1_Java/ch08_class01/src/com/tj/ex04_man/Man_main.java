package com.tj.ex04_man;

public class Man_main {
	public static void main(String[] args) {
		Man park = new Man(168, 57);
		// park : ��ü���� = ���۷��� ���� = ��ü
		Man jeon = new Man();
		jeon.setHeight(183); // ������ ������, ������ �ʿ��� ��.
		jeon.setWeight(81);
		Man lee = new Man(183, 75);
		if(jeon.equals(lee)) {
			System.out.println("jeon ��ü������ lee ��ü������ ����.");
		}else {
			System.out.println("jeon ��ü������ lee ��ü������ �ٸ���.");
		}
		jeon = lee;
		if(jeon.equals(lee)) {
			System.out.println("jeon ��ü������ lee ��ü������ ����.");
		}else {
			System.out.println("jeon ��ü������ lee ��ü������ �ٸ���.");
		}
		double biman = park.calculateBMI();
		if(biman>24) {
			System.out.println("park���� ���Դϴ�.");
		}else {
			System.out.println("park���� ���� �ƴմϴ�.");
		}
		biman = jeon.calculateBMI();
		if(biman>24) {
			System.out.println("jeon���� ���Դϴ�.");
		}else {
			System.out.println(jeon.getClass().getName()+" jeon ���� ���� �ƴϳ׿�.");
		}
	}
}
