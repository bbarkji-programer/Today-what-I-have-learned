package com.tj.ex02_date;

import java.util.GregorianCalendar;

public class Ex03_gc {

	public static void main(String[] args) {
		
		GregorianCalendar gcThat = new GregorianCalendar(2019, 10, 25, 9, 30, 0); // Ư�� ������ �����Ѷ�.(��ǻ�� �ð��� �� ���)
		GregorianCalendar gcNow = new GregorianCalendar(); // ������ ������ �����Ѷ�.
		
		System.out.println("1970�� 1�� 1�� 0�� 0�� 0�ʺ��� ���ݱ����� �и������� ������ ����.");
		System.out.println(System.currentTimeMillis());
		System.out.println(gcNow.getTimeInMillis()); // 1970.1.1 ~ gc���������� �и�����
		System.out.println(gcThat.getTimeInMillis());
		
	}
}
