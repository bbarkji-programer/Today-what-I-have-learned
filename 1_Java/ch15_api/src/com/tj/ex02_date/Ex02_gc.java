package com.tj.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_gc {

	public static void main(String[] args) {
		
		GregorianCalendar gc = new GregorianCalendar(); // �̱��� �ƴ�. �� ������ -> ���� ��¥ ���
		System.out.println("[�׳� ���]");
		System.out.println(gc);
		
		int year = gc.get(Calendar.YEAR); // 2019
		int month = gc.get(Calendar.MONTH)+1; // ��ǻ�� month�� 0��~11�� �̶� +1 ����� ��. 
		int day = gc.get(Calendar.DAY_OF_MONTH); 
		int week = gc.get(Calendar.DAY_OF_WEEK); //��:1, ��:2, ȭ:3 ~ ��:7
		int hour24 = gc.get(Calendar.HOUR_OF_DAY); //24�ð� ����
		int ampm = gc.get(Calendar.AM_PM);
		int hour = gc.get(Calendar.HOUR);//12�ð� ����
		int minute = gc.get(Calendar.MINUTE); //��
		int second = gc.get(Calendar.SECOND); //��
		int milliSec = gc.get(Calendar.MILLISECOND); //�и�����
		
		System.out.println();
		System.out.println("[���Ӱ� ���]");
		System.out.printf("%d�� %d�� %d�� ", year, month, day);
		switch(week) {
		case 1: System.out.print("�Ͽ���");
		break;
		case 2: System.out.print("������");
		break;
		case 3: System.out.print("ȭ����");
		break;
		case 4: System.out.print("������");
		break;
		case 5: System.out.print("�����");
		break;
		case 6: System.out.print("�ݿ���");
		break;
		case 7: System.out.print("�����");
		break;
		}
		System.out.print((ampm==0)? " ���� " : " ���� ");
		System.out.printf("%d�� %d�� %d�� %d\n", hour, minute, second, milliSec);
		System.out.printf("24�ð� ���� : %d�� %d�� %d�� %d\n", hour24, minute, second, milliSec);
	}
}
