package com.tj.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// �����ϰ� ������ ������ִ�  api
public class Ex07_simpleDateFormat {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("(w����) yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		String todayStr = sdf.format(cal.getTime());
		// cal.getTime()�� cal�� date ������ �ٲ� ��.
		System.out.println(todayStr);
		// yyyy 2019 yy 19
		// M 9 MM 09
		// d 9 dd 09 �̹����� �� ��° ������(1~31)
		// D ������ �� ��° ������(1~365)
		// E ����
		// a ����/����
		// H 24�ð� ���� HH
		// h 12�ð� ���� hh
		// m 9 mm 09 ��
		// s 9 ss 09 ��
		// S �и�����
		// W �̹� ���� �� ��° ������
		// w �̹� �⵵�� �� ��° ������
		
	}
}
